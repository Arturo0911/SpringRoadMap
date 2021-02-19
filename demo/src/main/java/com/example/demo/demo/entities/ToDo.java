package com.example.demo.demo.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class ToDo {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;


    @NotBlank(message = "the field 'description' cannot be empty")
    @Getter @Setter
    private String description;

    /*@NotBlank(message = "the field 'date' cannot be empty")
    @Getter @Setter
    private Date date;*/


    @NotBlank(message = "the field 'priority' cannot be empty")
    @Getter @Setter
    private String priority;



    @NotBlank(message = "the field 'description' cannot be empty")
    @Getter @Setter
    private String fkUser;

    /*@PrePersist
    void initDate(){
        date = new Date();
    }*/

    public ToDo(){}

    public ToDo(@NotBlank(message = "the field 'description' cannot be empty") String description,
                //@NotBlank(message = "the field 'date' cannot be empty") Date date,
                @NotBlank(message = "the field 'priority' cannot be empty") String priority,
                @NotBlank(message = "the field 'description' cannot be empty") String fkUser) {
        this.description = description;
        //this.date = date;
        this.priority = priority;
        this.fkUser = fkUser;
    }








}
