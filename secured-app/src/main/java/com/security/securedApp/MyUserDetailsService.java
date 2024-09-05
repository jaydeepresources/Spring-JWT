package com.security.securedApp;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database
        // For now, we provide a dummy user

        AuthenticationRequest authenticationRequest = new AuthenticationRequest(username, AuthenticationController.encodedPassword);
        return
                org.springframework.security.core.userdetails.User.builder()
                        .username(authenticationRequest.getUsername())
                        .password(authenticationRequest.getPassword())
                        .build();
    }
}