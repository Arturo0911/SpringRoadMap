package com.service.demo.SpringServiceDemo.daos;

import com.service.demo.SpringServiceDemo.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoDao extends CrudRepository<ToDo, Integer> {

    //
    List<ToDo> findByFkUser(String email);


}
