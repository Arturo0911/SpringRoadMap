package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.UserService;
import com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers.UserNotInDataBaseException;
import com.company.socialnetwork.SocialNetworkMicroservice.utilities.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/getUsers")
    ResponseEntity<JsonResponseBody>getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userService.searchAllUsers()));
    }

    /**
     * @param user use a User object to save into Database
     * @return return ResponseEntity manage
     */
    @RequestMapping("/saveUsers")
    ResponseEntity<JsonResponseBody> addUsers(@RequestBody @Valid User user){

        /*
         * User object to be inserted
         *  names
         *  lastNames
         *  phoneNumber
         *  userBirth
         *  gender
         *  email
         *  password
         *  followers
         *
         *
         */

        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userService.saveNewUser(user)));
    }

    @RequestMapping("/info")
    ResponseEntity<JsonResponseBody> getUserInfo(int userId){
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userService.sendInfoUser(userId)));
    }

    @RequestMapping("/user/{userId}")
    ResponseEntity<JsonResponseBody> searchSpecificUser(@PathVariable int userId){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userService.searchSpecificUser(userId)));
        }catch (UserNotInDataBaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), e.toString()));
        }
    }


}
