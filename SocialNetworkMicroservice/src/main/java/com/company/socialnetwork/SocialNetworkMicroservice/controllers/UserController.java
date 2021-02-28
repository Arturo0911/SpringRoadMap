package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/")
    public String helloWorld(){
        return "hello world";
    }
}
