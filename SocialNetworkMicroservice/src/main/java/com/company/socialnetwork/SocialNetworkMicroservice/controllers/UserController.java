package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.UserService;
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
    @RequestMapping("/saveUsers")
    ResponseEntity<JsonResponseBody> addUsers(@RequestBody @Valid User user){
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userService.saveNewUser(user)));
    }

    @RequestMapping("/info")
    ResponseEntity<JsonResponseBody> getUserInfo(int userId){
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userService.sendInfoUser(userId)));
    }




}
