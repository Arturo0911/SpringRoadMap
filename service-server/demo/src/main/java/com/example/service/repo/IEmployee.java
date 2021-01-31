package com.example.service.repo;

import com.example.service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployee extends JpaRepository<Employee, Integer> {
    
}
