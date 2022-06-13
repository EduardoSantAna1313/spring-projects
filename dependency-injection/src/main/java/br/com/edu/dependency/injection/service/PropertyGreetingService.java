package br.com.edu.dependency.injection.service;

public class PropertyGreetingService implements GreetingService {

	@Override
	public String getGreeting() {
		return "Hello World - Property";
	}

}
