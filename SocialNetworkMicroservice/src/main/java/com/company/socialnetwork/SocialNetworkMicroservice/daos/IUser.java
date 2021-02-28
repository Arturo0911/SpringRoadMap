package com.company.socialnetwork.SocialNetworkMicroservice.daos;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User, Integer> {
}
