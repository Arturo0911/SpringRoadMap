package com.company.socialnetwork.SocialNetworkMicroservice.services;

import com.company.socialnetwork.SocialNetworkMicroservice.daos.IUser;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FollowServiceImplementation implements FollowService {

    @Autowired
    IUser iUser;

    @Override
    public void follow(int uerFollower, int userToFollow) {

    }

    /**
     * This process can be refactors using sync's or Main thread process
     * @param userFollower id from the user session
     * @param userToUnFollow user to follow
     */
    @Override
    public void unFollow(int userFollower, int userToUnFollow) {
        Optional<User> user = iUser.findById(userFollower);
        Optional<User> userToBeRemoved = iUser.findById(userToUnFollow);
        user.get().getFollowing().remove(userToBeRemoved.get());
    }
}
