package com.company.socialnetwork.SocialNetworkMicroservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter @Setter
    private Integer userId;

    @Column(name = "user_names", length = 25)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String names;

    @Column(name = "user_last_names", length = 25)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String lastNames;

    @Column(name = "user_phone_number", length = 25)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String phoneNumber;

    @Column(name = "user_birth")
    @Getter @Setter
    private Date userBirth; // can be nut or null

    @Column(name = "user_gender", length = 10)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String gender;

    @Column(name = "user_email", length = 25)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String email;

    @Column(name = "user_password", length = 100)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String password;



    /*
    * How many users yo follow
    *
    * */

    @ManyToMany
    @JoinTable(name = "users_follow",
            joinColumns = @JoinColumn(name = "user_id_follower"), inverseJoinColumns = @JoinColumn(name = "user_id_followed"))
    @Getter @Setter
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "userFollower")
    @Getter @Setter
    private Set<Following> followings = new HashSet<>();



}
