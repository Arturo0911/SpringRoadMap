package com.company.socialnetwork.SocialNetworkMicroservice.daos;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowing extends JpaRepository<Following, Integer> {

}
