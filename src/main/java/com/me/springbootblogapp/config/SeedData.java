package com.me.springbootblogapp.config;


import com.me.springbootblogapp.business.concretes.AccountManager;
import com.me.springbootblogapp.business.concretes.PostManager;
import com.me.springbootblogapp.entities.Account;
import com.me.springbootblogapp.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostManager postManager;

    @Autowired
    private AccountManager accountManager;



    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postManager.getAll();

        if (posts.size()==0){
            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("user1FirstName");
            account1.setLastName("user1LastName");
            account1.setEmail("user1@user.com");
            account1.setPassword("12345");

            account2.setFirstName("user2FirstName");
            account2.setLastName("user2LastName");
            account2.setEmail("user2@user.com");
            account2.setPassword("12345");

            accountManager.save(account1);
            accountManager.save(account2);

            Post post1=new Post();
            post1.setTitle("title of post 1");
            post1.setBody("This is the body of post 1");
            post1.setAccount(account1);

            Post post2=new Post();
            post2.setTitle("title of post 2");
            post2.setBody("This is the body of post 2");
            post2.setAccount(account2);

            postManager.save(post1);
            postManager.save(post2);


        }

    }
}
