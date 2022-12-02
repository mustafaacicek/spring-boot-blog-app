package com.me.springbootblogapp.business.concretes;

import com.me.springbootblogapp.business.abstracts.AccountService;
import com.me.springbootblogapp.dataAccess.abstracts.AccountRepository;
import com.me.springbootblogapp.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountManager implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
