package com.company.firstdemo.Microservice1.services;

import com.company.firstdemo.Microservice1.entities.User;
import com.company.firstdemo.Microservice1.utilities.UserNotInDatabaseException;
import com.company.firstdemo.Microservice1.utilities.UserNotLoggedException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public interface LoginService {

    Optional<User> getUserFromDb(String email, String password) throws UserNotInDatabaseException;
    String createJWT(String email, String name, Date date) throws UnsupportedEncodingException;

    Map<String, Object> verifyJWTAndGetData(HttpServletRequest request) throws UnsupportedEncodingException, UserNotLoggedException;

}
