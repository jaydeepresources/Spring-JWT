package com.security.securedApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "application_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(unique = true)
    private String username;
    private String password;
    private String role;
    private String name;
    private String imgUrl;
    private String bio;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(Long userId) {
        this.userId = userId;
    }

}