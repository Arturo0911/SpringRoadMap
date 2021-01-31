package com.example.service.demo.repo;

import com.example.service.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployee extends JpaRepository<Employee, Integer> {
    
}
