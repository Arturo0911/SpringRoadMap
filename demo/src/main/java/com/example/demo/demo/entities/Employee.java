package com.example.demo.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "the field 'name' cannot be empty")
    @Getter @Setter
    private String name;

    @NotBlank(message = "the field 'lastName' cannot be empty")
    @Getter @Setter
    private String lastName;

    @NotBlank(message = "the field 'email' cannot be empty")
    @Getter @Setter
    private String email;

    @NotBlank(message = "the field 'deprtmentName' cannot be empty")
    @Getter @Setter
    private String departmentName;

    @NotBlank(message = "the field 'phoneNumber' cannot be empty")
    @Getter @Setter
    private String phoneNumber;

    @NotBlank(message = "the field 'username' cannot be empty")
    @Getter @Setter
    private String username;

    @NotBlank(message = "the field 'password' cannot be empty")
    @Getter @Setter
    private String password;

    public Employee() {
    }

    public Employee(@NotBlank(message = "the field 'name' cannot be empty") String name, @NotBlank(message = "the field 'lastName' cannot be empty") String lastName, @NotBlank(message = "the field 'email' cannot be empty") String email, @NotBlank(message = "the field 'deprtmentName' cannot be empty") String departmentName, @NotBlank(message = "the field 'phoneNumber' cannot be empty") String phoneNumber, @NotBlank(message = "the field 'username' cannot be empty") String username, @NotBlank(message = "the field 'password' cannot be empty") String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.departmentName = departmentName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }
}
