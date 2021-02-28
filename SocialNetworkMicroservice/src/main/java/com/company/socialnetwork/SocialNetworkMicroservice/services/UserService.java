package com.company.socialnetwork.SocialNetworkMicroservice.services;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers.UserNotInDataBaseException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> searchAllUsers();
    Optional<User> searchSpecificUser(Integer id) throws UserNotInDataBaseException;
    User saveNewUser(User user);

}
