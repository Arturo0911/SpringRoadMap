package com.service.demo.SpringServiceDemo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "todos")
@AllArgsConstructor @NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Getter @Setter
    private Integer id;

    @Column(name = "DESCRIPTION")
    @Getter @Setter
    @NotBlank(message = "the field 'description' cannot be empty")
    private String description;

    @Column(name = "DATE")
    @Getter @Setter
    @NotBlank(message = "the field 'date' cannot be empty")
    private Date date;

    @Column(name = "PRIORITY")
    @Getter @Setter
    @NotBlank(message = "the field 'priority' cannot be empty")
    private String priority;

    @Column(name = "FK_USER")
    @Getter @Setter
    @NotBlank(message = "the field 'fkUser' cannot be empty")
    private String fkUser;


    @PrePersist
    void getTimeOperation(){
        this.date = new Date();
    }



}
