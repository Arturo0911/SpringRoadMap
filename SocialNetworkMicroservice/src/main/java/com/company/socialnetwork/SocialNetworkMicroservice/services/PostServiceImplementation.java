package com.company.socialnetwork.SocialNetworkMicroservice.services;

import com.company.socialnetwork.SocialNetworkMicroservice.daos.IPost;
import com.company.socialnetwork.SocialNetworkMicroservice.daos.IUser;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.Post;
import com.company.socialnetwork.SocialNetworkMicroservice.entities.User;
import com.company.socialnetwork.SocialNetworkMicroservice.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Arturo Negreiros
 */


@Service
public class PostServiceImplementation implements PostService {

    /**
     *
     * TODO:
     *      - simply crud
     *      - taking in an account the userId
     */

    @Autowired
    IPost iPost;

    @Autowired
    IUser iUser;

    @Override
    public Optional<Post> findPostById(Integer postId) {
        return iPost.findById(postId);
    }


    @Override
    public List<Post> searchPostByUserId(Integer userId) {

        iPost.findPostsByUserId(userId);
        return iPost.findPostsByUserId(userId);
    }

    @Override
    public Post newPost(Post post) {
        return iPost.save(post);
    }

    @Override
    public void updatePost(Post post) {
        Post postToSave = new Post();
        postToSave.setPostId(post.getPostId());
        postToSave.setPostDate(post.getPostDate());
        postToSave.setPostContent(post.getPostContent());
        iPost.save(postToSave);
    }

    @Override
    public void deletePost(Integer postId) {
        iPost.deleteById(postId);
    }
}
