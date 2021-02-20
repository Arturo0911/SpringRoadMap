package com.company.firstdemo.Microservice1.services;

import com.company.firstdemo.Microservice1.entities.ToDo;

import java.util.List;

public interface ToDoService {

    List<ToDo> getToDos(String email);

    ToDo addToDo(ToDo toDo);

    void deleteToDo(Integer id);

}
