package com.company.gateway.Gateway.controller;


import com.company.gateway.Gateway.services.JsonResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class RouterUserController {

    /*
    * Such the MVC architecture of spring projects, we gonna to create
    * the same structure of the project to manage the right way
    * to access and send of data between the client and the microservice
    * */

    @GetMapping("/")
    ResponseEntity<JsonResponseBody> searchAllUsers(){
        
    }
}
