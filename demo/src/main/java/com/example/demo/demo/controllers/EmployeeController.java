package com.example.demo.demo.controllers;


import com.example.demo.demo.daos.EmployeeDao;
import com.example.demo.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/employee")
    public List<Employee> getEmployee(Employee employee){
        return (List<Employee>) employeeDao.findAll();
    }

    @RequestMapping("/get_employee")
    public String setEmployee(@Valid Employee employee){
        /*
        *
        * this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.departmentName = departmentName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        *
        * */

        return "The employee name: "+employee.getName();
    }



}
