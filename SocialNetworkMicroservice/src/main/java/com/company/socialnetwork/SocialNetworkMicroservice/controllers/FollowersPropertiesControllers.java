package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.interfaces.FollowService;
import com.company.socialnetwork.SocialNetworkMicroservice.utilities.JsonResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/followers")
public class FollowersPropertiesControllers {

    @Autowired
    private FollowService followService;


    @RequestMapping("/getFollowings/{userId}")
    ResponseEntity<JsonResponseBody> getFollowers(@PathVariable("userId") int userId){
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), followService.getAllFollowings(userId)));

    }

    @RequestMapping("/followUser/{id}")
    ResponseEntity<JsonResponseBody> followUser(@RequestBody @Valid User user, @PathVariable("id") int id){
        int userId = user.getUserId();
        followService.follow(userId, id);
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), user));
    }

    @RequestMapping("/info/{id}")
    ResponseEntity<JsonResponseBody> unFollowsUser(@RequestBody @Valid User user, @PathVariable("id") int id){
        int userId = user.getUserId();
        followService.unFollow(user.getUserId(), id);
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userId ));
    }
}
