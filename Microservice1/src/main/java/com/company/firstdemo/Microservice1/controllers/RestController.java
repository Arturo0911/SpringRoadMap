package com.company.firstdemo.Microservice1.controllers;


import com.company.firstdemo.Microservice1.entities.ToDo;
import com.company.firstdemo.Microservice1.entities.User;
import com.company.firstdemo.Microservice1.services.LoginService;
import com.company.firstdemo.Microservice1.services.ToDoService;
import com.company.firstdemo.Microservice1.utilities.JsonResponseBody;
import com.company.firstdemo.Microservice1.utilities.ToDoValidator;
import com.company.firstdemo.Microservice1.utilities.UserNotInDatabaseException;
import com.company.firstdemo.Microservice1.utilities.UserNotLoggedException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * @author Arturo Negreiros Samanez -> Arturo0911
 *
 * */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    LoginService loginService;

    @Autowired
    ToDoService toDoService;


    @RequestMapping("/hello")
    ResponseEntity<String>hello(){
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @RequestMapping("/todo")
    public String getFirstToDo(ToDo toDo){
        return "Description is: "+toDo.getDescription();
    }


    /*
    * using binding result, we catch the errors and show such a String.
    * */
    @RequestMapping("/doto")
    public String getSecondToDo(@Valid ToDo toDo, BindingResult result){

        if (result.hasErrors()){
            return "The error/errors: "+result.getAllErrors();
        }
        return "Description is: "+toDo.getDescription();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<JsonResponseBody>login(@RequestParam(value = "email") String email,
                                                 @RequestParam(value = "password") String password){

        try {
            Optional<User> userr = loginService.getUserFromDb(email, password);
            User user = userr.get();
            String jwt = loginService.createJWT(email, user.getName(),new Date());

            return ResponseEntity.status(HttpStatus.OK).header("jwt", jwt).body(new JsonResponseBody(HttpStatus.OK.value(), "success login"));

        }catch (UserNotInDatabaseException | UnsupportedEncodingException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Forbidden"+e.toString()));
        }

    }

    @RequestMapping("/showtodo")
    public ResponseEntity<JsonResponseBody> showToDo(HttpServletRequest request){
        try {
            Map<String, Object> userData = loginService.verifyJWTAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),toDoService.getToDos((String) userData.get("email"))));
        }catch (UnsupportedEncodingException | UserNotLoggedException  e  ){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "error"+e.toString()));
        }
    }

    @RequestMapping(value = "/newtodo", method = RequestMethod.POST)
    ResponseEntity<JsonResponseBody> newTodo (HttpServletRequest request, @Valid ToDo toDo, BindingResult result){
        ToDoValidator toDoValidator = new ToDoValidator();
        toDoValidator.validate(toDo, result);

        if(result.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Errors in"+result.getAllErrors()));
        }

        try{
            loginService.verifyJWTAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), toDoService.addToDo(toDo)));
        } catch ( ExpiredJwtException | UserNotLoggedException | UnsupportedEncodingException exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Forbidden request"));
        }


    }

    @RequestMapping("/deleteToDo/{id}")
    ResponseEntity<JsonResponseBody>deleteToDo(HttpServletRequest request, @PathVariable(name = "id") Integer id){
        try {
            loginService.verifyJWTAndGetData(request);
            toDoService.deleteToDo(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "Success, ToDo deleted correctly"));
        }catch ( ExpiredJwtException | UserNotLoggedException | UnsupportedEncodingException exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Forbidden request"));
        }
    }




}
