package com.company.socialnetwork.SocialNetworkMicroservice.services;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.Followers;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;

import java.util.List;
import java.util.Optional;

public interface FollowersServices {

    List<Followers> getFollowers();
    Optional<Followers> getFollowersById(Integer id);
    Followers FollowToUser(Followers followers);

}
