package com.me.springbootblogapp.business.concretes;

import com.me.springbootblogapp.business.abstracts.AccountService;
import com.me.springbootblogapp.dataAccess.abstracts.AccountRepository;
import com.me.springbootblogapp.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountManager implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findOneByEmail(email);
    }
}
