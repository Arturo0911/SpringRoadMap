package com.company.socialnetwork.SocialNetworkMicroservice.services;


import com.company.socialnetwork.SocialNetworkMicroservice.daos.IUser;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers.UserNotInDataBaseException;
import com.company.socialnetwork.SocialNetworkMicroservice.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
     * TODO:
     * @param user new user to be inserted
     * @return User object whenever is saved
     */
    @Override
    public User saveNewUser(User user) {
        return iUser.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        Optional<User> user = iUser.findById(userId);
        user.get().setStatus("Inactive");
        iUser.save(user.get());
    }

    @Override
    public User updateUser(User user) {
        // in the postman section send the id for updating
        try {
            return iUser.save(user);
        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param userToFollower the session active from te user
     * @param userToFollow the user who gonna follow
     */
    public void follow(int userToFollower, int userToFollow) {

        Optional<User> findUserToFollow = iUser.findById(userToFollow);
        Optional<User> userFollower = iUser.findById(userToFollower);
        userFollower.ifPresent(user -> user.getFollowing().add(findUserToFollow.get()));
        iUser.save(userFollower.get());

    }

    /**
     * @param user primary key to fetch the from database
     * @return object which the user info and how many users are following
     */
    public Object sendInfoUser(int user){
        Optional<User> userFound = iUser.findById(user);
        HashMap<Object, Object> userInfo = new HashMap<>();
        userInfo.put("User", userFound);
        userInfo.put("Following",userFound.get().getFollowing().size());
        return userInfo;
    }

    /**
     *
     * @param id from the user follower
     * @return all the followers
     */
    public List<User> getAllFollowers(Integer id) {
        Optional<User> user = iUser.findById(id);
        return user.map(User::getFollowing).orElse(null);

    }
}
