package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import com.company.socialnetwork.SocialNetworkMicroservice.utilities.JsonResponseBody;
import com.company.socialnetwork.SocialNetworkMicroservice.utilities.messagesresponse.MessageStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @RequestMapping("/greeting")
    public String  greeting(){
        return "Post sections";
    }

    @GetMapping("/getAllPost/{userId}")
    ResponseEntity<JsonResponseBody> getPostByUserId(@PathVariable("userId") Integer userId){
        try {

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), MessageStatusCode.errorStatus));
        }
    }
}
