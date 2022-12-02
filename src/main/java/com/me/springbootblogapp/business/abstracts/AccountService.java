package com.me.springbootblogapp.business.abstracts;


import com.me.springbootblogapp.entities.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Account save(Account account);

    
}
