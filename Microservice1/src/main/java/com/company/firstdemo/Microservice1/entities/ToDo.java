package com.company.firstdemo.Microservice1.entities;


import com.sun.jdi.PrimitiveValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
//import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Getter @Setter
    private Integer id;

    @Column(name = "DESCRIPTION")
    @Getter @Setter
    @NotNull(message = "the field cannot be null")
    @NotBlank(message = "the field cannot be blank")
    @NotEmpty(message = "the field cannot be empty")
    private String description;

    @Column(name = "DATE")
    @Getter @Setter
    private Date date;

    @Column(name = "PRIORITY")
    @Getter @Setter
    @NotNull @NotBlank @NotEmpty
    private String priority;

    @Column(name = "FK_USER")
    @Getter @Setter
    @NotNull @NotBlank @NotEmpty
    private String fkUser;

    @PrePersist
    void getTimeOperation(){
        this.date = new Date();
    }

}
