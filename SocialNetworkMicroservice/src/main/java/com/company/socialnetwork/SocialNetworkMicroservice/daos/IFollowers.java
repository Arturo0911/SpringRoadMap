package com.company.socialnetwork.SocialNetworkMicroservice.daos;


import com.company.socialnetwork.SocialNetworkMicroservice.entities.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowers extends JpaRepository<Followers, Integer> {
}
