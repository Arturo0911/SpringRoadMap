package com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers;

public class PostNotInDatabaseException extends Exception {

    public PostNotInDatabaseException(String message){
        super(message);
    }
}
