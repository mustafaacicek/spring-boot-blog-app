package com.me.springbootblogapp.controllers;

import com.me.springbootblogapp.business.concretes.AccountManager;
import com.me.springbootblogapp.business.concretes.PostManager;
import com.me.springbootblogapp.entities.Account;
import com.me.springbootblogapp.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostManager postManager;

    @Autowired
    private AccountManager accountManager;

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

    @GetMapping("/posts/new")
    public String createNewPost(Model model){
        Optional<Account> optionalAccount= accountManager.findByEmail("user1@user.com");
        if (optionalAccount.isPresent()){
            Post post =new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post",post);
            return "post_new";

        }else {
            return "404";
        }

    }
    @PostMapping("/posts/new")
    public String saveNewPost(@ModelAttribute Post post){
        postManager.save(post);
        return "redirect:/posts/" + post.getId();
    }
    @GetMapping("/posts/{id}/edit")
    @PreAuthorize("isAuthenticated")
    public String getPostForEdit(@PathVariable Long id, Model model){

        //find post by id
        Optional<Post> optionalPost = postManager.getById(id);
        //if post exist put it in model
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post",post);
            return "post_edit";
        }else {
            return "404";
        }
    }

    @PostMapping("/posts/{id}")
    @PreAuthorize("isAuthenticated()")
    public String updatePost(@PathVariable Long id, Post post, BindingResult result, Model model) {

        Optional<Post> optionalPost = postManager.getById(id);
        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();

            existingPost.setTitle(post.getTitle());
            existingPost.setBody(post.getBody());

            postManager.save(existingPost);
        }

        return "redirect:/posts/" + post.getId();
    }
    @GetMapping("/posts/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePost(@PathVariable Long id) {

        // find post by id
        Optional<Post> optionalPost = postManager.getById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            postManager.delete(post);
            return "redirect:/";
        } else {
            return "404";
        }
    }


}
