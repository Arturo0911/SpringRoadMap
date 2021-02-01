package com.example.service.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.example.service.demo.model.UserLoginCredentials;
import com.example.service.demo.repo.IUserLoginCredentials;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private IUserLoginCredentials iUserLoginCredentials;

	@Autowired
	private BCryptPasswordEncoder encode;


	@Test
	public void ceateUserTest() {
		
		UserLoginCredentials userLog = new UserLoginCredentials();
		userLog.setIdUser(2);
		userLog.setUsername("Linux");
		userLog.setPassword(encode.encode("Blessed"));
		userLog.setEmailAddress("payloadmail@payload.com");

		UserLoginCredentials UserLogObject = iUserLoginCredentials.save(userLog);
		assertTrue(UserLogObject.getPassword().equals(userLog.getPassword()));
	
	
	}

}
