package com.example.service.demo.services;

import java.util.*;

import com.example.service.demo.model.UserLoginCredentials;
import com.example.service.demo.repo.IUserLoginCredentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService{

    @Autowired
    private IUserLoginCredentials iUserLogin;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// TODO Auto-generated method stub
        UserLoginCredentials userReturn =  iUserLogin.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();

        roles.add(new SimpleGrantedAuthority("ADMIN"));


        

        UserDetails userDet = new User(userReturn.getUsername(), userReturn.getPassword(), roles);
        return userDet;
            
    };
	
     
}
