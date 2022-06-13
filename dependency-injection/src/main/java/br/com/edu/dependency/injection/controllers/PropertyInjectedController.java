package br.com.edu.dependency.injection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.edu.dependency.injection.service.GreetingService;

@Controller
public class PropertyInjectedController {

	@Qualifier("propertyGreetingService")
	@Autowired
	public GreetingService greetingService;

	public String getGreeting() {
		return greetingService.getGreeting();
	}

}
