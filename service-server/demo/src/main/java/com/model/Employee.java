package com.model;

public class Employee {

    private String credentials;
    private String name;
    private String lastNames;
    private String phoneNumber;
    private String emailAddress;
    private String departmentName;
    private String username;
    private String password;

    public Employee(){

    }

    public Employee(String credentials, String name, String lastNames,
                        String phoneNumber, String emailAddress, String departmentName,
                        String username, String password) {
        this.setCredentials(credentials);
        this.setName(name);
        this.setLastNames(lastNames);
        this.setPhoneNumber(phoneNumber);
        this.setEmailAddress(emailAddress);
        this.setDepartmentName(departmentName);
        this.setUsername(username);
        this.setPassword(password);
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
}
