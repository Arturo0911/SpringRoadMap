package com.example.demo.demo.daos;


import com.example.demo.demo.entities.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoDao extends CrudRepository<ToDo, Integer> {}
