package com.company.socialnetwork.SocialNetworkMicroservice.services;


import com.company.socialnetwork.SocialNetworkMicroservice.daos.IUser;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers.UserNotInDataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        }
        return users;
    }

    @Override
    public User saveNewUser(User user) {
        return null;
    }
}