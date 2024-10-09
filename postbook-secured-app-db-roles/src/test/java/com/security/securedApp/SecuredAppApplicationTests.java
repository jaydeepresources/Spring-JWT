package com.security.securedApp;

import com.security.securedApp.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecuredAppApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
		Assertions.assertEquals(2, userRepository.count());
	}
}