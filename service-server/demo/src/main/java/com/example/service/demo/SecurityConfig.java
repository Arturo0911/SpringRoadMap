	package com.example.service.demo;

import com.example.service.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserService userDetailsService;


    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * Whevereer request incoming would have to authenticated 
         * 
        */
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/product/list_product").permitAll()
            .antMatchers(HttpMethod.POST, "/product/insertion").permitAll()
            .antMatchers(HttpMethod.PUT, "/product/updating").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }




}
