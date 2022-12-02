package com.me.springbootblogapp.controllers;

import com.me.springbootblogapp.business.concretes.PostManager;
import com.me.springbootblogapp.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostManager postManager;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model){
        //find the post by id
        Optional<Post> optionalPost=postManager.getById(id);
        //if the post exists, then shove it into the model
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post",post);
            return "post";
        }else {
            return "404";
        }

    }
}
