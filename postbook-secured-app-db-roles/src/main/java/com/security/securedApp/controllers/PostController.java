package com.security.securedApp.controllers;

import com.security.securedApp.dto.PostUser;
import com.security.securedApp.dto.PostUserRecord;
import com.security.securedApp.dto.UserAddPost;
import com.security.securedApp.dto.UserEntireRecord;
import com.security.securedApp.entity.Post;
import com.security.securedApp.repositories.PostRepository;
import com.security.securedApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    //    TODO: Return all Posts
    public List<PostUser> getPosts(){
        return postRepository.findBy();
    }

    //    TODO: Insert a new Post
    @PostMapping("/posts")
    public PostUserRecord insertPost(@RequestBody Post post){

        Post insertedPost = postRepository.save(post);

        return new PostUserRecord(insertedPost.getPostId(),insertedPost.getPostBody(),
                new UserAddPost(insertedPost.getUser().getUserId(),insertedPost.getUser().getName(),insertedPost.getUser().getImgUrl()));
    }

}