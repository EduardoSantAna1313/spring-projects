package br.com.edu.dependency.injection.controllers;

import org.springframework.stereotype.Controller;

import br.com.edu.dependency.injection.service.GreetingService;

@Controller
public class MyController {

	private final GreetingService greetingService;

	public MyController(final GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayHello() {
		return greetingService.getGreeting();
	}
}
