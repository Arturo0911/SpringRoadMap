package com.service.demo.SpringServiceDemo.daos;

import com.service.demo.SpringServiceDemo.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoDao extends JpaRepository<ToDo, Integer> {

    //
    List<ToDo> findByFkUser(String email);


}
