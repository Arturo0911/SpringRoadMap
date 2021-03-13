package com.company.socialnetwork.SocialNetworkMicroservice.controllers;


import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.interfaces.UserService;
import com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers.UserNotInDataBaseException;
import com.company.socialnetwork.SocialNetworkMicroservice.utilities.JsonResponseBody;
import com.company.socialnetwork.SocialNetworkMicroservice.utilities.messagesresponse.MessageStatusCode;
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
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),
                MessageStatusCode.successStatus,userService.searchAllUsers()));
    }

    /**
     * @param user use a User object to save into Database
     * @return return ResponseEntity manage
     */
    @RequestMapping("/saveUsers")
    ResponseEntity<JsonResponseBody> addUsers(@RequestBody @Valid User user){
        user.setStatus("Active");
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),
                MessageStatusCode.successStatus, userService.saveNewUser(user)));
    }

    @RequestMapping("/delete/{userId}")
    ResponseEntity<JsonResponseBody> deleteUser(@PathVariable("userId") int userId){
        try {
            userService.deleteUser(userId);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),
                    MessageStatusCode.successStatus,"User deleted" ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                    MessageStatusCode.errorStatus,e.toString()));
        }

    }

    @RequestMapping("/user/{userId}")
    ResponseEntity<JsonResponseBody> searchSpecificUser(@PathVariable("userId") Integer userId){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),
                    MessageStatusCode.successStatus, userService.searchSpecificUser(userId)));
        }catch (UserNotInDataBaseException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                    MessageStatusCode.errorStatus, e.toString()));
        }
    }

    @RequestMapping("/updateUser")
    ResponseEntity<JsonResponseBody> updateUser(@RequestBody @Valid User user){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(),
                    MessageStatusCode.successStatus, userService.updateUser(user)));
        }catch (Exception e ){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                    MessageStatusCode.errorStatus, e.toString()));
        }
    }


}
