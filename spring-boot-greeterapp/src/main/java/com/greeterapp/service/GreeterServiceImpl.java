package com.greeterapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GreeterServiceImpl implements IGreeterService {

	@Override
	public String greetUser(String username) {
		return "welcome "+username;
	}

	@Override
	public List<String> showMessages() {
		return Arrays.asList("Hello","Hi","Great day");
	}

}
