package com.security.securedApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostUserRecord {

    private Long postId;
    private String postBody;
    private UserAddPost user;

    public PostUserRecord(Long postId) {
        this.postId = postId;
    }

}
