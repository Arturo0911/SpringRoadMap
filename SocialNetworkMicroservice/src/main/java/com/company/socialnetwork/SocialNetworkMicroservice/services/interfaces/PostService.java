package com.company.socialnetwork.SocialNetworkMicroservice.services.interfaces;

import com.company.socialnetwork.SocialNetworkMicroservice.entities.Post;

import java.util.Optional;

public interface PostService {

    Optional<Post> searchPostById(Integer postId);
    Post newPost(Post post);
    void updatePost(Post post);
}
