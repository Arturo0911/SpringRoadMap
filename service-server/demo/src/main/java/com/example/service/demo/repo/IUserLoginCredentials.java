package com.example.service.demo.repo;

import com.example.service.demo.model.UserLoginCredentials;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserLoginCredentials extends JpaRepository<UserLoginCredentials, Integer> {
    
}
