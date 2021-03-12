package com.company.socialnetwork.SocialNetworkMicroservice.daos;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPost extends JpaRepository<Post, Integer> {
}
