package com.company.socialnetwork.SocialNetworkMicroservice.services.interfaces;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Optional<Post> findPostById(Integer postId);
    List<Post> searchPostByUserId(Integer userId);
    Post newPost(Post post);
    void updatePost(Post post);
    void deletePost(Integer postId);
}
