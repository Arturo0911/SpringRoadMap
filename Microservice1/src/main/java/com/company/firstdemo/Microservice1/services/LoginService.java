package com.company.firstdemo.Microservice1.services;

import com.company.firstdemo.Microservice1.entities.User;
import com.company.firstdemo.Microservice1.utilities.UserNotInDatabaseException;
import com.company.firstdemo.Microservice1.utilities.UserNotLoggedException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;



/**
 * @author Arturo Payload
 */


public interface LoginService {

    Optional<User> getUserFromDb(String email, String pwd) throws UserNotInDatabaseException;

    String createJwt(String email, String name, Date date) throws UnsupportedEncodingException;

    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request)throws UnsupportedEncodingException, UserNotLoggedException; //ExpiredJwtException;
}
