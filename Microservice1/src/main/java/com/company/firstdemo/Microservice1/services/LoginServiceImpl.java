package com.company.firstdemo.Microservice1.services;

import com.company.firstdemo.Microservice1.daos.UserDao;
import com.company.firstdemo.Microservice1.entities.User;
import com.company.firstdemo.Microservice1.utilities.EncryptionUtils;
import com.company.firstdemo.Microservice1.utilities.JwtUtils;
import com.company.firstdemo.Microservice1.utilities.UserNotInDatabaseException;
import com.company.firstdemo.Microservice1.utilities.UserNotLoggedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    UserDao userDao;

    @Autowired
    EncryptionUtils encryptionUtils;

    @Autowired
    JwtUtils jwtUtils;



    @Override
    public Optional<User> getUserFromDb(@NotNull String email, @NotNull String pwd) throws UserNotInDatabaseException{

        Optional<User> userr = userDao.findUserByEmail(email);
        if(userr.isPresent()){
            User user = userr.get();
            if(! encryptionUtils.decrypt(user.getPassword()).equals(pwd)){
                throw new UserNotInDatabaseException("Wrong email or password!");
            }
        }
        return userr;
    }



    @Override
    public String createJwt(@NotNull String email, @NotNull String name, @NotNull Date date) throws UnsupportedEncodingException{
        date.setTime(date.getTime() + (300*1000));
        return jwtUtils.generateJwt(email, name, date);
    }



    @Override
    public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request)throws UnsupportedEncodingException, UserNotLoggedException{//, ExpiredJwtException{
        String jwt = jwtUtils.getJwtFromHttpRequest(request);
        if(jwt == null){
            throw new UserNotLoggedException("User not logger! Login first.");
        }
        return jwtUtils.jwt2Map(jwt);
    }

}