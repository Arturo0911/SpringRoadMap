package com.company.firstdemo.Microservice1.daos;

import com.company.firstdemo.Microservice1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, String> {

    Optional<User> findUserByEmail(String email);

}
