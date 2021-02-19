package com.company.firstdemo.Microservice1.daos;

import com.company.firstdemo.Microservice1.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoDao extends JpaRepository<ToDo, Integer> {

    List<ToDo> findByFkUser(String email);
}
