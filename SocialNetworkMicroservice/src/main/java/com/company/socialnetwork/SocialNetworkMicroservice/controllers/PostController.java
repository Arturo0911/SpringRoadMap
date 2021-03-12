package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @RequestMapping("/greeting")
    public String  greeting(){
        return "Post sections";
    }
}
