package com.example.demo.demo.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "The field 'name' cannot be empty")
    private String name;

    @NotBlank(message = "The field 'email' cannot be empty")
    private String email;


    public User(){}

    public User(long id,String name,String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
