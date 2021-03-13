package com.company.socialnetwork.SocialNetworkMicroservice.utilities.structures;


import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Arturo Negreiros
 */

@Service
public class UserStructure {

    /**
     * TODO:
     *      - the goal or purpose of this class is build a object with the necessary parameters
     *          to send to the client.
     *      - An User object with the follow parameters:
     *          -- userId
     *          -- userName
     *          -- userLastName
     *          -- userBirth
     *          -- userPhoneNumber
     */

    public HashMap formatUser(User user){

        HashMap<Object, Object> userManagement = new HashMap<>();
        userManagement.put("userId", user.getUserId());
        userManagement.put("userName", user.getNames());
        userManagement.put("userLastName", user.getLastNames());
        userManagement.put("userBirth", user.getUserBirth());
        userManagement.put("userPhoneNumber", user.getPhoneNumber());
        return userManagement;
    }

    public List formatUsers(List<User> users){

        List<HashMap<Object, Object>> allUsersManagement = new ArrayList<>();
        for(User user: users){
            allUsersManagement.add(formatUser(user));
        }
        return allUsersManagement;
    }



}
