package com.security.securedApp.dto;

import com.security.securedApp.entity.User;

public interface PostUser {

    public Long getPostId();
    public String getPostBody();
    public User getUser();

    interface User{
        public Long getUserId();
        public String getName();
        public String getImgUrl();
    }

}
