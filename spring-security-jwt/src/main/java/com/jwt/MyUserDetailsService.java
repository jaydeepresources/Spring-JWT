package com.jwt;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        
    	// fetch the details from DB and crosscheck against String s
    	// repo.findByUserName(s);
    	
    	return new User("foo", "foo",
                new ArrayList<>());
    	
    	// return null if user details don't match
    }
}