package com.example.service.repo;

import com.example.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Integer> {
}
