package com.company.firstdemo.Microservice1.daos;

import com.company.firstdemo.Microservice1.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToDoDao extends JpaRepository<ToDo, Integer> {

    List<ToDo> findByFkUser(String email);

    @Override
    void deleteById(Integer integer);

    /*@Modifying
    @Query("delete from todos where ID =:id")
    void delete(Integer id);*/
    //void deleteByName(@Param("id") Integer id);

}
