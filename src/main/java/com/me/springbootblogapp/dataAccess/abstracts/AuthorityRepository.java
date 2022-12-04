package com.me.springbootblogapp.dataAccess.abstracts;

import com.me.springbootblogapp.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,String> {
}
