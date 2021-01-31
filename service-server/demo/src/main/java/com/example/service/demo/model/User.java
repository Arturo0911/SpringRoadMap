package com.example.service.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private int Id;

    @Column(name = "names", length = 100)
    private String Names;

    /*public User(int id, String names) {
        Id = id;
        Names = names;
    }*/

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }



    



}
