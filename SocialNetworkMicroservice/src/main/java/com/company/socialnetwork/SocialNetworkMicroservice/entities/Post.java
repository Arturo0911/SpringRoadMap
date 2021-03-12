package com.company.socialnetwork.SocialNetworkMicroservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "posts")
@AllArgsConstructor @NoArgsConstructor
public class Post {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_content")
    @Getter @Setter
    @NotNull
    private String postContent;

    @Column(name = "post_date")
    @Getter @Setter
    private Date postDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @PrePersist
    void generateDate(){
        this.postDate = new Date();
    }
}
