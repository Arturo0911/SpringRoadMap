package com.company.socialnetwork.SocialNetworkMicroservice.services;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers.UserNotInDataBaseException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> searchAllUsers(); //1

    Optional<User> searchSpecificUser(Integer id) throws UserNotInDataBaseException; //2

    User saveNewUser(User user); //3

    void deleteUser(int userId); //4

    User updateUser(User user); //5


}
