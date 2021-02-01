package com.example.service.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLoginCredentials {

    @Id
    private int idUser;

    private String username;
    private String password;
    private String emailAddress;

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
		this.username = username;
    }

    public int getIdUser(){
        return idUser;
    }

    public void setIdUser(int idUser){

        this.idUser = idUser;
    }
    



}
