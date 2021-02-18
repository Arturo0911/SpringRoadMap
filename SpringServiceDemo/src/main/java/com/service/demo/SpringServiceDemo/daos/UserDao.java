package com.service.demo.SpringServiceDemo.daos;

import com.service.demo.SpringServiceDemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<User, String> {

    Optional<User>  findUserByEmail(String email);

}
