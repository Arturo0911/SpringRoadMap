package com.company.firstdemo.Microservice1.controllers;


import com.company.firstdemo.Microservice1.entities.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import javax.validation.Valid;

/**
 * @author Arturo Negreiros Samanez -> Arturo0911
 *
 * */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
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
    @RequestMapping("/response")
    public ResponseEntity<JsonResponseBody>returnData(){
        return ResponseEntity.status(HttpStatus.OK).header("jwt", jwt)
    }


}
