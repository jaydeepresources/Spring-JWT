package com.security.securedApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntireRecord {

    private Long userId;
    private String username;
    private String password;
    private String role;
    private String name;
    private String imgUrl;
    private String bio;

    public UserEntireRecord(Long userId) {
        this.userId = userId;
    }

}