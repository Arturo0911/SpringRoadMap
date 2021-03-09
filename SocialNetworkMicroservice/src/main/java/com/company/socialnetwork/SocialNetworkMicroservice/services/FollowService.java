package com.company.socialnetwork.SocialNetworkMicroservice.services;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;

public interface FollowService {


    void follow(int uerFollower, int userToFollow );
    void unFollow(int userFollower, int userToUnFollow);
}
