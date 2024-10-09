package com.security.securedApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAddPost {

    private Long userId;
    private String name;
    private String imgUrl;

    public UserAddPost(Long userId) {
        this.userId = userId;
    }

}