package com.me.springbootblogapp.business.concretes;

import com.me.springbootblogapp.business.abstracts.MyUserDetailsService;
import com.me.springbootblogapp.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component("userDetailService")
public class MyUserDetailsManager implements MyUserDetailsService , UserDetailsService {

    @Autowired
    private AccountManager accountManager;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountManager.findByEmail(email);
        if (!optionalAccount.isPresent()){
            throw new UsernameNotFoundException("Account not found");
        }
        Account account = optionalAccount.get();

        List<GrantedAuthority> grantedAuthorities = account
                .getAuthorities()
                .stream()
                .map(authority-> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());

        return new User(account.getEmail(),account.getPassword(),grantedAuthorities);
    }


}
