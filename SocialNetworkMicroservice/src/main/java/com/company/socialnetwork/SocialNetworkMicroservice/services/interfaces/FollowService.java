package com.company.socialnetwork.SocialNetworkMicroservice.services.interfaces;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;

import java.util.List;

public interface FollowService {


    void follow(int uerFollower, int userToFollow );
    void unFollow(int userFollower, int userToUnFollow);
    List<User> getAllFollowings(int userId);
}
