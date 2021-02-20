package com.company.firstdemo.Microservice1.services;

import com.company.firstdemo.Microservice1.daos.UserDao;
import com.company.firstdemo.Microservice1.entities.User;
import com.company.firstdemo.Microservice1.utilities.EncryptionUtils;
import com.company.firstdemo.Microservice1.utilities.JwtUtils;
import com.company.firstdemo.Microservice1.utilities.UserNotInDatabaseException;
import com.company.firstdemo.Microservice1.utilities.UserNotLoggedException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public class LoginServiceImpl implements LoginService {


    @Autowired
    UserDao userDao;

    @Autowired
    EncryptionUtils encryptionUtils;

    @Autowired
    JwtUtils jwtUtils;


    @Override
    public Optional<User> getUserFromDb(String email, String password) throws UserNotInDatabaseException {

        Optional<User> userr = userDao.findUserByEmail(email);
        if (userr.isPresent()){
            User user = userr.get();
            if (!encryptionUtils.decrypt(user.getPassword()).equals(password)){
                throw new UserNotInDatabaseException("Wrong email or password");
            }

        }else{
            throw new UserNotInDatabaseException("Wrong email or password");
        }

        return userr;
    }

    @Override
    public String createJWT(String email, String name, Date date) throws UnsupportedEncodingException {
        date.setTime(date.getTime() + (300+1000));
        return jwtUtils.createJWT(email, name, date);
    }


    @Override
    public Map<String, Object> verifyJWTAndGetData(HttpServletRequest request) throws UnsupportedEncodingException, UserNotLoggedException {

        String jwt = jwtUtils.getJwtFromHttpRequest(request);

        if (jwt == null){
            throw new UserNotLoggedException("user not logged ");
        }

        return jwtUtils.jwt2Map(jwt);

    }
}
