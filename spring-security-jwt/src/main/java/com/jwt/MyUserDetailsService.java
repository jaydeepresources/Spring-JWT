package com.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.models.AuthenticationRequest;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

		// fetch the details from DB and crosscheck against String s
		// repo.findByUserName(s);
		
		AuthenticationRequest auth = userRepository.findByUsername(s);

		return new User(auth.getUsername(), auth.getPassword(), new ArrayList<>());

		// return null if user details don't match
	}
}