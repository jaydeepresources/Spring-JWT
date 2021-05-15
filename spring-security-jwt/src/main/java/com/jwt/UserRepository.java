package com.jwt;

import org.springframework.data.repository.CrudRepository;

import com.jwt.models.AuthenticationRequest;

public interface UserRepository extends CrudRepository<AuthenticationRequest, Integer> {

	AuthenticationRequest findByUsernameAndPassword(String username, String password);
	AuthenticationRequest findByUsername(String username);

}
