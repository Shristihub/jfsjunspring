package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.ApiUser;
import com.bookapp.service.ApiUserServiceImpl;

@RestController
@RequestMapping("/user-api/v1/")
public class ApiUserController {
	@Autowired
	private ApiUserServiceImpl apiUserService;
	
	@PostMapping("/api-users")
	public ResponseEntity<Void> createUser(@RequestBody ApiUser user) {
		apiUserService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED.value()).build();
	}
	

	

}
