package com.example.demo.demo.controllers;


import com.example.demo.demo.daos.UserDao;
import com.example.demo.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return (List<User>) userDao.findAll();
    }


    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user){
        return ResponseEntity.ok("User is valid");
    }

    @RequestMapping("/users2")
    public String checkUser(@Valid User user, BindingResult result){

        if (result.hasErrors()){
            return "these are the errors: "+result.getAllErrors().toString();
        }

        return "the user is: "+user.getName()+" and this is your email: "+user.getEmail();
    }



    /*
    * The method stores the name and post-validation error message of each invalid field in a Map.
    * Next it sends the Map back to the client as a JSON representation for further processing.
    * */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        // Created the hashmap with all the errors to be showed
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
