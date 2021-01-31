package com.example.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
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

    public Employee(){

    }

    public Employee(String credentials, String name, String lastNames,
                        String phoneNumber, String emailAddress, String departmentName,
                        String username, String password, String userCredentialWorkd) {
        this.setCredentials(credentials);
        this.setName(name);
        this.setLastNames(lastNames);
        this.setPhoneNumber(phoneNumber);
        this.setEmailAddress(emailAddress);
        this.setDepartmentName(departmentName);
        this.setUsername(username);
        this.setPassword(password);
        this.setUserCredentialWorkd(userCredentialWorkd);
    }


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
