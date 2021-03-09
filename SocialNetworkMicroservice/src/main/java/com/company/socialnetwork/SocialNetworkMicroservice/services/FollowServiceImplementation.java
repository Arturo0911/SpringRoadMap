package com.company.socialnetwork.SocialNetworkMicroservice.services;

import com.company.socialnetwork.SocialNetworkMicroservice.daos.IUser;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowServiceImplementation implements FollowService {

    @Autowired
    IUser iUser;

    /**
     *
     * @param userToFollower the user whom gonna follow
     * @param userToFollow the following
     */
    @Override
    public void follow(int userToFollower, int userToFollow) {
        Optional<User> findUserToFollow = iUser.findById(userToFollow);
        Optional<User> userFollower = iUser.findById(userToFollower);
        userFollower.ifPresent(user -> user.getFollowing().add(findUserToFollow.get()));
        iUser.save(userFollower.get());
    }

    /**
     * This process can be refactors using sync's or Main thread process
     * @param userFollower id from the user session
     * @param userToUnFollow user to unfollow
     */
    @Override
    public void unFollow(int userFollower, int userToUnFollow) {
        Optional<User> user = iUser.findById(userFollower);
        Optional<User> userToBeRemoved = iUser.findById(userToUnFollow);
        user.get().getFollowing().remove(userToBeRemoved.get());
    }

    /**
     *
     * @param userId identification to fetch the user object
     * @return return the list of the 'followings'
     */
    @Override
    public List<User> getAllFollowings(int userId) {
        try {
            Optional<User> user = iUser.findById(userId);
            return user.get().getFollowing();
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }
}
