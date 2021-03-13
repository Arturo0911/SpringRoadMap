package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import com.company.socialnetwork.SocialNetworkMicroservice.services.interfaces.PostService;
import com.company.socialnetwork.SocialNetworkMicroservice.utilities.JsonResponseBody;
import com.company.socialnetwork.SocialNetworkMicroservice.utilities.messagesresponse.MessageStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("/greeting")
    public String  greeting(){
        return "Post sections";
    }

    @GetMapping("/getAllPost/{userId}")
    ResponseEntity<JsonResponseBody> getPostByUserId(@PathVariable("userId") Integer userId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),
                    MessageStatusCode.successStatus, postService.searchPostByUserId(userId)));

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), MessageStatusCode.errorStatus, e.toString()));
        }
    }
}
