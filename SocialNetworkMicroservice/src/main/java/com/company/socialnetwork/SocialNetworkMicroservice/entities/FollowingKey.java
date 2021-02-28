package com.company.socialnetwork.SocialNetworkMicroservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
@AllArgsConstructor @NoArgsConstructor
public class FollowingKey implements Serializable {

    @Column(name = "user_id_follower")
    @Getter @Setter
    Integer userIdFollower;

    @Column(name = "user_id_followed")
    @Getter @Setter
    Integer userIdFollowed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowingKey that = (FollowingKey) o;
        return Objects.equals(userIdFollower, that.userIdFollower) && Objects.equals(userIdFollowed, that.userIdFollowed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdFollower, userIdFollowed);
    }
}
