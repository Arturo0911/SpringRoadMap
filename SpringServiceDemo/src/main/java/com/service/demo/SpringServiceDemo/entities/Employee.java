package com.service.demo.SpringServiceDemo.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor @NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer identificator;


    @Column(name = "NAME")
    @Getter @Setter
    @NotBlank(message = "The filed 'name' cannot be empty")
    private String name;


}
