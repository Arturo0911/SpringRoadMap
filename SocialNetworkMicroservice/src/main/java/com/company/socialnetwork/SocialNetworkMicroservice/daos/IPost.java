package com.company.socialnetwork.SocialNetworkMicroservice.daos;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPost extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM posts WHERE user_id =:userId", nativeQuery = true)
    public List<Post> findPostsByUserId(@Param("userId") Integer userId);
}
