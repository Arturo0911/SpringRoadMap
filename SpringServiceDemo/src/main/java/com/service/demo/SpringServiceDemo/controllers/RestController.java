package com.service.demo.SpringServiceDemo.controllers;


import com.service.demo.SpringServiceDemo.entities.Employee;
import com.service.demo.SpringServiceDemo.entities.ToDo;
import com.service.demo.SpringServiceDemo.entities.User;
import com.service.demo.SpringServiceDemo.utilities.ToDoValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author Arturo Negreiros Samanez
 * */

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

    @RequestMapping("/employee")
    public Employee findEmployee(){
        return new Employee(1, "Arturo Negreiros");
    }

    @RequestMapping("/getemployee")
    public String getEmployee(Employee employee){

        return "the identificator: "+String.valueOf(employee.getIdentificator()) + " and the name: "+employee.getName();
    }

    @RequestMapping("/getemployee2")
    public String getEmployee2(@Valid @RequestBody Employee employee, BindingResult result){

        if(result.hasErrors()){
            return "this one is the error or errors: "+result.toString();
        }

        return "the identificator: "+String.valueOf(employee.getIdentificator()) + " and the name: "+employee.getName();
    }


    @RequestMapping("/todo4")
    public String todoInInput4(ToDo toDo, BindingResult result){

        ToDoValidator validator = new ToDoValidator();
        validator.validate(toDo, result);

        if (result.hasErrors()){
            return "i return the error in the format i like "+result.toString();
        }
        return "Todo description: "+toDo.getDescription()+", todo priority "+toDo.getPriority();
    }




}
