package com.company.socialnetwork.SocialNetworkMicroservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "all_followers")
public class Followers {


    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FollowersTableId;

    @ManyToMany
    @JoinTable(name = "users_follow", joinColumns = @JoinColumn(name = "user_id_follower"),inverseJoinColumns = @JoinColumn(name = "user_id_followed"))
    @NotBlank(message = "The camp of followers ")
    @Getter @Setter
    private Set<User> users;

}
