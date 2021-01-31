package com.example.service.demo.res;

import com.example.service.demo.repo.IUser;

import java.util.List;

import com.example.service.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RestDemoController {
    
    @Autowired
    private IUser iUser;



    @GetMapping
    public List<User> list(){
        return iUser.findAll();
    }


    @PostMapping
    public void insertUser(@RequestBody User user){
        iUser.save(user);

    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        
        iUser.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        iUser.deleteById(id);
    }





}
