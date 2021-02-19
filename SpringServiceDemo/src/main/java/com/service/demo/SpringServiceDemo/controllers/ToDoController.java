package com.service.demo.SpringServiceDemo.controllers;


import com.service.demo.SpringServiceDemo.daos.ToDoDao;
import com.service.demo.SpringServiceDemo.entities.Employee;
import com.service.demo.SpringServiceDemo.entities.ToDo;
import com.service.demo.SpringServiceDemo.entities.User;
import com.service.demo.SpringServiceDemo.utilities.ToDoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arturo Negreiros Samanez
 * */

@org.springframework.web.bind.annotation.RestController
public class ToDoController {

    private final ToDoDao toDoDao;

    @Autowired
    public ToDoController(ToDoDao toDoDao){
        this.toDoDao = toDoDao;
    }

    @RequestMapping("/todo")
    public String todoInInput5(@Valid ToDo toDo){

        return "Todo description: "+toDo.getDescription()+", todo priority "+toDo.getPriority();
    }

    @PostMapping("/todo_user")
    ResponseEntity<String>addToDo(@Valid @RequestBody ToDo toDo){
        return ResponseEntity.ok("ToDo is valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}
