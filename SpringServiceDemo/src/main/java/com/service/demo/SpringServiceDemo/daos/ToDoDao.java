package com.service.demo.SpringServiceDemo.daos;

import com.service.demo.SpringServiceDemo.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoDao extends CrudRepository<ToDo, Integer> {

    //
    List<ToDo> findByFkUser(String email);


}
