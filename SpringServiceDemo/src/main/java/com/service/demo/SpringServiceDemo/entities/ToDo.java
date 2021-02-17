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
    @NotNull @NotEmpty @NotBlank
    private String description;

    @Column(name = "DATE")
    @Getter @Setter
    @NotNull @NotEmpty @NotBlank
    private Date date;

    @Column(name = "PRIORITY")
    @Getter @Setter
    @NotNull @NotEmpty @NotBlank
    private String priority;

    @Column(name = "FK_USER")
    @Getter @Setter
    @NotNull @NotEmpty @NotBlank
    private String fkUser;


    @PrePersist
    void getTimeOperation(){
        this.date = new Date();
    }



}
