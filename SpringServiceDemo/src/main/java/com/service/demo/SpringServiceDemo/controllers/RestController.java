package com.service.demo.SpringServiceDemo.controllers;


import com.service.demo.SpringServiceDemo.entities.ToDo;
import com.service.demo.SpringServiceDemo.entities.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello ";
    }

    @RequestMapping("/user")
    public User giveMeUser(){
        return new User("anegreiross@outlook.com", "Arturo Negreiros", "MyUbuntu");
    }

    @RequestMapping("/todo1")
    public String todoInInput1(ToDo toDo){
        return "Todo description: "+toDo.getDescription()+", todo priority "+toDo.getPriority();
    }
    @RequestMapping("/todo")
    public String todoInInput2(@Valid ToDo toDo){
        return "Todo description: "+toDo.getDescription()+", todo priority "+toDo.getPriority();
    }


    // collecting errors
    @RequestMapping("/todo3")
    public String todoInInput3(@Valid ToDo toDo, BindingResult result){


        if (result.hasErrors()){
            return "i return the error in the format i like "+result.toString();
        }
        return "Todo description: "+toDo.getDescription()+", todo priority "+toDo.getPriority();
    }


}
