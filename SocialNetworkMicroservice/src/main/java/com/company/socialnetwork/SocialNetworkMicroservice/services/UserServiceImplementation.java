package com.company.socialnetwork.SocialNetworkMicroservice.services;


import com.company.socialnetwork.SocialNetworkMicroservice.daos.IUser;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers.UserNotInDataBaseException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private IUser iUser;


    @Override
    public List<User> searchAllUsers() {
        return iUser.findAll();
    }

    @Override
    public Optional<User> searchSpecificUser(Integer id) throws UserNotInDataBaseException {

        Optional<User> users = iUser.findById(id);
        if(users.isPresent()){
            User user = users.get();
            if(user.getUserId() == null){
                throw new UserNotInDataBaseException("THe user is not present in database");
            }

        }
        return users;
    }

    /**
     *
     * @param user object to be inserted into database
     * @return the new user saved
     */
    @Override
    public User saveNewUser(User user) {
        return iUser.save(user);
    }

    @Override
    public List<User> getFollowers(User user) {
        return user.getFollowers();
    }

    /**
     *
     * @param userFollower the sesion active from te user
     * @param userToFollow the user who gonna follow
     * @return the user followed
     */
    @Override
    public void follow(int userFollower, int userToFollow) {

        Optional<User> findUserToFollow = iUser.findById(userToFollow);
        Optional<User> userFollowerr = iUser.findById(userFollower);
        userFollowerr.get().getFollowers().add(findUserToFollow.get());

        iUser.save(userFollowerr.get());

    }

    /**
     *
     * @param user primary key to fetch the from database
     * @return object whicn the user info and how many users are following
     */
    @Override
    public Object sendInfoUser(int user){
        Optional<User> userFound = iUser.findById(user);
        HashMap<Object, Object> userInfo = new HashMap<>();
        userInfo.put("User", userFound);
        userInfo.put("Following",userFound.get().getFollowers().size());
        return userInfo;
    }

    /**
     * This process can be refacotores using async's or Main thread proces
     * @param userFollower
     * @param userToDelete
     */
    @Override
    public void unFollowUser(int userFollower, int userToDelete){
        Optional<User> user = iUser.findById(userFollower);
        Optional<User> userToBeRemoved = iUser.findById(userToDelete);
        user.get().getFollowers().remove(userToBeRemoved.get());
    }
}
