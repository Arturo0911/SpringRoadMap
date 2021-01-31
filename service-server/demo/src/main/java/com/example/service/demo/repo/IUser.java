package com.example.service.demo.repo;

import com.example.service.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Integer> {
}
