package com.company.socialnetwork.SocialNetworkMicroservice.entities;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
public class User {

    private String names;
    private String lastNames;
    private String phoneNumber;
    private Date userBirth; // can be nut or null
    private String gender;
    private Integer userId;
    private String email;
    private String password;


}
