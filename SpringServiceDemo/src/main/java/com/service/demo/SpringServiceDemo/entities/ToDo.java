package com.service.demo.SpringServiceDemo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
//@Table(name = "todos")
//@AllArgsConstructor @NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "ID")
    //@Getter @Setter
    private Integer id;

    //@Column(name = "DESCRIPTION")
    //@Getter @Setter
    @NotBlank(message = "the field 'description' cannot be empty")
    private String description;

    //@Column(name = "DATE")
    //@Getter @Setter
    @NotBlank(message = "the field 'date' cannot be empty")
    private Date date;

    //@Column(name = "PRIORITY")
    //@Getter @Setter
    @NotBlank(message = "the field 'priority' cannot be empty")
    private String priority;

    //@Column(name = "FK_USER")
    //@Getter @Setter
    @NotBlank(message = "the field 'fkUser' cannot be empty")
    private String fkUser;


    /*@PrePersist
    void getTimeOperation(){
        this.date = new Date();
    }*/

    public ToDo(){}

    public ToDo(@NotBlank(message = "the field 'description' cannot be empty") String description, @NotBlank(message = "the field 'priority' cannot be empty") String priority, @NotBlank(message = "the field 'fkUser' cannot be empty") String fkUser) {
        //this.id = id;
        this.description = description;
        //this.date = date;
        this.priority = priority;
        this.fkUser = fkUser;
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getFkUser() {
        return fkUser;
    }

    public void setFkUser(String fkUser) {
        this.fkUser = fkUser;
    }
}
