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


    /* test examples */

    @RequestMapping("/hello")
    public String sayHello(){           //it returns a String
        return "Hello everyone!";
    }

    @RequestMapping("/userInOutput")
    public User giveMeAUser(){
        return new User("mike@quicktutorialz.com", "Mike Anthony", "HisPassword");  //json got from JacksonLibrary
    }

    /* databinding and validation examples */

    //simple databinding
    @RequestMapping("/todoInInput1")
    public String toDoInInput1(ToDo toDo){
        return "ToDo Description: " + toDo.getDescription() + ", ToDo Priority: " + toDo.getPriority();
    }

    //databinding with JSR-303 validation managed by JAVA
    @RequestMapping("/todoInInput2")
    public String toDoInInput2(@Valid ToDo toDo){
        return "ToDo Description: " + toDo.getDescription() + ", ToDo Priority: " + toDo.getPriority();
    }

    //databinding with JSR-303 validation managed by BindingResult
    @RequestMapping("/todoInInput3")
    public String toDoInInput3(@Valid ToDo toDo, BindingResult result){
        if(result.hasErrors()){
            return "I return the error with my format: " + result.toString();
        }
        return "ToDo Description: " + toDo.getDescription() + ", ToDo Priority: " + toDo.getPriority();
    }


    //databinding with spring validation managed by BindingResult
    @RequestMapping("/todoInInput4")
    public String toDoInInput2(ToDo toDo, BindingResult result){

        ToDoValidator validator = new ToDoValidator();  //spring validator fills the BindingResult object
        validator.validate(toDo, result);

        if(result.hasErrors()){
            return "I return the error with my format: " + result.toString();
        }
        return "ToDo Description: " + toDo.getDescription() + ", ToDo Priority: " + toDo.getPriority();
    }

    //databinding with JSR-303 + spring validation managed by BindingResult
    @RequestMapping("/todoInInput5")
    public String toDoInInput5(@Valid ToDo toDo, BindingResult result){

        ToDoValidator validator = new ToDoValidator();  //spring validator fills the BindingResult object
        validator.validate(toDo, result);

        if(result.hasErrors()){
            return "I return the error with my format: " + result.toString();
        }
        return "ToDo Description: " + toDo.getDescription() + ", ToDo Priority: " + toDo.getPriority();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<JsonResponseBody> login(@RequestParam(value="email") String email, @RequestParam(value="password") String pwd){

        //1) success: return String with login message + JWT in the HEADER of the HTTP RESPONSE
        //2) fail:    return Error message

        try{
            Optional<User> userr = loginService.getUserFromDb(email, pwd);
            if(userr.isPresent()){
                User user = userr.get();
                String jwt = loginService.createJwt(email, user.getName(), new Date());
                //the only case in which the server send the JWT to the client (in the HEADER of HTTP RESPONSE)
                return ResponseEntity.status(HttpStatus.OK).header("jwt", jwt).body(new JsonResponseBody(HttpStatus.OK.value(), "Success! You logged in."));
            }
        }catch(UnsupportedEncodingException e1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Error: " + e1.toString()));
        }catch(UserNotInDatabaseException e2){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "No corrispondence in the database of users"));
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Problems during log in! Contact the support."));
    }




    @RequestMapping("/showToDos")
    public ResponseEntity<JsonResponseBody> showToDos(HttpServletRequest request){

        //1) success: ArrayList of ToDos in the "response" attribute of JsonResponseBody
        //2) fail:    error message

        try{
            Map<String, Object> userData = loginService.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), toDoService.getToDos((String) userData.get("email"))));
        }catch(UnsupportedEncodingException e1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad Request: " + e1.toString()));
        }catch(UserNotLoggedException e2){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "User not logged! Login first : " + e2.toString()));
        }catch(ExpiredJwtException e3){
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JsonResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), "Session Expired!: " + e3.toString()));
        }
    }




    @RequestMapping(value = "/newToDo", method=RequestMethod.POST)
    public ResponseEntity<JsonResponseBody> newToDo(HttpServletRequest request, @Valid ToDo toDo, BindingResult result){

        //1) success: ToDoInserted into the response attribute of JsonResponseBody
        //2) fail:    error message

        ToDoValidator validator = new ToDoValidator();  //spring validator fills the BindingResult object
        validator.validate(toDo, result);

        if(result.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Error: " + result.toString()));
        }

        try{
            loginService.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), toDoService.addToDo(toDo)));
        }catch(UserNotLoggedException e1){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "User not logged! Login first : " + e1.toString()));
        }catch(UnsupportedEncodingException e2){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad Request: " + e2.toString()));
        }catch(ExpiredJwtException e3){
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JsonResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), "Session Expired!: " + e3.toString()));
        }
    }




    @RequestMapping("/deleteToDo/{id}")
    public ResponseEntity<JsonResponseBody> deleteToDo(HttpServletRequest request, @PathVariable(name="id") Integer toDoId){

        //1) success: message of success in 'response' attribute of JsonResponseBody
        //2) fail:    error message

        try{
            loginService.verifyJwtAndGetData(request);
            toDoService.deleteToDo(toDoId);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), "ToDo correctly deleted"));
        }catch(UserNotLoggedException e1){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "User not logged! Login first : " + e1.toString()));
        }catch(UnsupportedEncodingException e2){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad Request: " + e2.toString()));
        }catch(ExpiredJwtException e3){
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JsonResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), "Session Expired!: " + e3.toString()));
        }
    }
}
