package com.example.service.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    @Column(name = "credentials", length = 50)
    private String credentials;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "lastNames", length = 100)
    private String lastNames;

    @Column(name = "phoneNumber", length = 50)
    private String phoneNumber;

    @Column(name = "emailAddress", length = 50)
    private String emailAddress;

    @Column(name = "departmentName", length = 50)
    private String departmentName;

    @Column(name = "userCredentials", length = 50)
    private String userCredentialWorkd;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 200)
    private String password;
    
    
    /*
     * 
     * Getters and Setters
     * */

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCredentialWorkd() {
        return userCredentialWorkd;
    }

    public void setUserCredentialWorkd(String userCredentialWorkd) {
        this.userCredentialWorkd = userCredentialWorkd;
    }
}
