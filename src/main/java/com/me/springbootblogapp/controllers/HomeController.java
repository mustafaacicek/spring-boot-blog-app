package com.me.springbootblogapp.controllers;

import com.me.springbootblogapp.business.concretes.PostManager;
import com.me.springbootblogapp.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PostManager postManager;

    @GetMapping("/")
    public String home(Model model){
        List<Post> posts = postManager.getAll();
        model.addAttribute("posts",posts);
        return "home";
    }
}
