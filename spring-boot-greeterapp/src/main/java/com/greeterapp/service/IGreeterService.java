package com.greeterapp.service;


import java.util.List;

public interface IGreeterService {

	String greetUser(String username);
	List<String> showMessages();
}
