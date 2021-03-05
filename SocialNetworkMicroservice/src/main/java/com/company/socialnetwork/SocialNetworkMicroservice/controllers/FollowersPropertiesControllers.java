package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.UserService;
import com.company.socialnetwork.SocialNetworkMicroservice.utilities.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/followers")
public class FollowersPropertiesControllers {

    @Autowired
    private UserService userService;


    @RequestMapping("/getFollowings")
    ResponseEntity<JsonResponseBody> getFollowers(User user){
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userService.getFollowers(user)));

    }

    @RequestMapping("/followUser/{id}")
    ResponseEntity<JsonResponseBody> followUser(@RequestBody @Valid User user, @PathVariable("id") int id){
        int userId = user.getUserId();
        userService.follow(userId, id);
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), user));
    }

    @RequestMapping("/info/{id}")
    ResponseEntity<JsonResponseBody> unFollowsUser(@RequestBody @Valid User user, @PathVariable("id") int id){
        int userId = user.getUserId();
        userService.unFollowUser(user.getUserId(), id);
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userId ));
    }
}
