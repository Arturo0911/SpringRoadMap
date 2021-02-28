package com.company.rest.college.CollegeMicroService.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@AllArgsConstructor @NoArgsConstructor
public class Student {

    private Integer studentId;

    

}
