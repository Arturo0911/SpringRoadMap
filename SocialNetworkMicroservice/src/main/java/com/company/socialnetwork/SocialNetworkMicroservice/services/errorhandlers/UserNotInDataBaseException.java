package com.company.socialnetwork.SocialNetworkMicroservice.services.errorhandlers;

public class UserNotInDataBaseException extends Exception {
    public UserNotInDataBaseException(String message){super(message);}
}
