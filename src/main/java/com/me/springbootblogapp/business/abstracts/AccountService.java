package com.me.springbootblogapp.business.abstracts;


import com.me.springbootblogapp.entities.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {

    Account save(Account account);

    Optional<Account> findByEmail(String email);

    
}
