package br.com.edu.dependency.injection.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.edu.dependency.injection.service.GreetingService;

@Controller
public class I18nController {

	private final GreetingService greetingService;

	public I18nController(@Qualifier("i18nService") final GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayGreeting() {
		return greetingService.getGreeting();
	}

}
