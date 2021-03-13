package com.company.socialnetwork.SocialNetworkMicroservice.utilities.structures;


import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

/**
 * @author Arturo Negreiros
 */

@AllArgsConstructor @NoArgsConstructor
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
    @Getter @Setter
    public static final HashMap<Object, Object> userManagement = new HashMap<>();

    public HashMap formatUser(User user){



        return null;
    }

    public List formatUsers(List<User> users){
        return null;
    }



}
