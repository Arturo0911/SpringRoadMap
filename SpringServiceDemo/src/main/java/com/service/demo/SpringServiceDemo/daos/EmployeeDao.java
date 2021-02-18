package com.service.demo.SpringServiceDemo.daos;

import com.service.demo.SpringServiceDemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByIdentificator(Integer identificator);
}
