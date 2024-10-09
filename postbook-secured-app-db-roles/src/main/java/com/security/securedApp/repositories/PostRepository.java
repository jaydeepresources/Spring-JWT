package com.security.securedApp.repositories;

import com.security.securedApp.dto.PostUser;
import com.security.securedApp.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    public List<PostUser> findBy();

}