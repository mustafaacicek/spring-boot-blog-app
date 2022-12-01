package com.me.springbootblogapp.business.abstracts;

import com.me.springbootblogapp.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Optional<Post> getById(Long id);
    List<Post> getAll();
    Post save(Post post);

}
