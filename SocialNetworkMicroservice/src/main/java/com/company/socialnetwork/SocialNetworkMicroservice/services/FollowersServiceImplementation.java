package com.company.socialnetwork.SocialNetworkMicroservice.services;

import com.company.socialnetwork.SocialNetworkMicroservice.daos.IFollowers;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.Followers;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FollowersServiceImplementation implements FollowersServices {

    @Autowired
    IFollowers iFollowers;

    @Override
    public List<Followers> getFollowers() {
        return iFollowers.findAll();
    }

    @Override
    public Optional<Followers> getFollowersById(Integer id) {

        Optional<Followers> follower = iFollowers.findById(id);
        if(follower.isPresent()){
            Followers followers = follower.get();
        }
        return follower;
    }

    @Override
    public Followers FollowToUser(Followers followers) {
        return iFollowers.save(followers);
    }
}
