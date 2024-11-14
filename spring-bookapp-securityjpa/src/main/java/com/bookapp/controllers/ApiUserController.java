package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.ApiUser;
import com.bookapp.service.ApiUserServiceImpl;

@RestController
@RequestMapping("/user-api/v1")
public class ApiUserController {
	@Autowired
	private ApiUserServiceImpl apiUserService;
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/api-users/register")
	public ResponseEntity<Void> createUser(@RequestBody ApiUser user) {
		String password = user.getPassword();
		String newpassword = encoder.encode(password);
		user.setPassword(newpassword);
		System.out.println(user);
		
		apiUserService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED.value()).build();
	}
	

	

}
