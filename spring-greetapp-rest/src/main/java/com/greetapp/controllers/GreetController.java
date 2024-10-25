package com.greetapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	// add methods which are REST Endpoints or Rest APIs
	
	// http://localhost:8080/greet
	@GetMapping("/greet")
	public String greetMessage() {
		return "Have a great day";
	}
	//http://localhost:8080/show-books
	@GetMapping("/show-books")
	public List<String> showBooks(){
		return Arrays.asList("Java","spring");
	}
	// send data in the url
   // http://localhost:8080/welcome-user/priya
	@GetMapping("/welcome-user/{uname}")
	public String welcomeUser(@PathVariable("uname") String username) {
		return "Welcome "+ username;
	}
	//http://localhost:8080/show/username/priya/city/ooty
	@GetMapping("/show/username/{username}/city/{city}")
	public String printDetails(@PathVariable String username,@PathVariable  String city) {
		return "Welcome "+ username +" from "+city;
	}
	// data comes from a form - this is query string
	//username and userid are name of form fields
	// http://localhost:8080/print-details?username=Priya&userid=10
	@GetMapping("/print-details")
	public String print(@RequestParam String username, @RequestParam("userid") int id) {
		return "Welcome "+ username +" with id "+id;
	}
	
}







