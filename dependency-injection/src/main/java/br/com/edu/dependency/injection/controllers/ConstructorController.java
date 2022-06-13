package br.com.edu.dependency.injection.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.edu.dependency.injection.service.GreetingService;

@Controller
public class ConstructorController {

	private final GreetingService greetingService;

	public ConstructorController(@Qualifier("constructorGreetingService") final GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String getGreeting() {
		return greetingService.getGreeting();
	}
}
