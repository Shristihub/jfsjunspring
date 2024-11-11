package com.greetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class GreetController {
	
	@GetMapping("/greet")
	public String greetMessage(Model model) {
		// call the service layer and service returns result
		// set the data to a model
		// no service layer
		//so create some data 
		String data = "Have a great day";
		//and attach to model message is the dummy name
		model.addAttribute("message", data);
		// now return the view page name
		return "success";
	}

	@GetMapping("/welcome")
	public String welcomeMessage(ModelMap map) {
		// no service
		// create data and attach to model
	    map.addAttribute("message","Welcome to Spring MVC");
	    return "success";
	}
	
	@GetMapping("/sayHello")
	public ModelAndView sayHello( ) {
		// modelandview creates a model and returns a view directly
		ModelAndView modelview = new ModelAndView("success","message","Hello guys");
		return modelview;
	}
}
