package com.company.socialnetwork.SocialNetworkMicroservice.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonFormat(pattern="dd/MM/yy")
    private Date userBirth; // can be nut or null

    @Column(name = "user_gender", length = 10)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String gender;

    @Column(name = "user_status", length = 10)
    @Getter @Setter
    @NotNull @NotBlank
    private String status;

    @Column(name = "user_email", length = 25)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String email;

    @Column(name = "user_password", length = 100)
    @Getter @Setter
    @NotNull @NotBlank @NotBlank
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_relations", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "following_id"))
    @Getter @Setter
    private List<User> following;

    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private List<Post>posts;


}
