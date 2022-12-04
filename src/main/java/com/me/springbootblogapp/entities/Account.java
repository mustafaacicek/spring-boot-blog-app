package com.me.springbootblogapp.entities;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
    joinColumns = {@JoinColumn (name="account_id", referencedColumnName = "id")},
     inverseJoinColumns = {@JoinColumn(name = "authority_name",referencedColumnName = "name")})
    private Set<Authority> authorities=new HashSet<>();

    @Override
    public String toString(){
        return "Account{" +
                ", firstName='" + firstName + "'" +
                ", lastName='" + lastName + "'" +
                ", email='" + email + "'" +
                ", authorities='" + authorities +
                "}";
    }

}
