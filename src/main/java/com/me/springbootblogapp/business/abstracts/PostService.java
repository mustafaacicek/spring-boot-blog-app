package com.me.springbootblogapp.business.abstracts;

import com.me.springbootblogapp.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {
    Optional<Post> getById(Long id);
    List<Post> getAll();
    Post save(Post post);

    void delete(Post post);

}
