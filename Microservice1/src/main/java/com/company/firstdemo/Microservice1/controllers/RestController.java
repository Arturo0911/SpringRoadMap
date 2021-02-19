package com.company.firstdemo.Microservice1.controllers;


import com.company.firstdemo.Microservice1.entities.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @RequestMapping("/doto")
    public String getSecondToDo(@Valid ToDo toDo, BindingResult result){

        if (result.hasErrors()){
            return "The error/errors: "+result.getAllErrors();
        }
        return "Description is: "+toDo.getDescription();
    }
}
