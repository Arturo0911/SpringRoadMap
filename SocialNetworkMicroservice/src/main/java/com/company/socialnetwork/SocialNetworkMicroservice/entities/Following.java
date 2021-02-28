package com.company.socialnetwork.SocialNetworkMicroservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "following")
@AllArgsConstructor @NoArgsConstructor
public class Following {


    @EmbeddedId
    private FollowingKey followingKey;

    @ManyToOne
    @MapsId("userIdFollower")
    @JoinColumn(name = "user_id_follower")
    @Getter @Setter
    private User userFollower;

    @ManyToOne
    @MapsId("userIdFollowed")
    @JoinColumn(name = "user_id_followed")
    @Getter @Setter
    private User userFollowed;

    @Column(name = "following")
    @Getter @Setter
    @NotBlank @NotBlank @NotBlank
    private Integer following;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Following following1 = (Following) o;
        return Objects.equals(followingKey, following1.followingKey) && Objects.equals(userFollower, following1.userFollower) && Objects.equals(userFollowed, following1.userFollowed) && Objects.equals(following, following1.following);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followingKey, userFollower, userFollowed, following);
    }
}
