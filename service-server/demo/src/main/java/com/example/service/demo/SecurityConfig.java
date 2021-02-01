package com.example.service.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder;
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        


        auth
            .inMemoryAuthentication()
            .withUser("user")
                .password("password")
                .roles("USER")
                .and()
    }




}
