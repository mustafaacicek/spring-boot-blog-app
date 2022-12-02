package com.me.springbootblogapp.dataAccess.abstracts;

import com.me.springbootblogapp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
