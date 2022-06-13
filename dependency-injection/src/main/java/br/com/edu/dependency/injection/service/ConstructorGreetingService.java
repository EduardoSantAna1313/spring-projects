package br.com.edu.dependency.injection.service;

public class ConstructorGreetingService implements GreetingService {

	@Override
	public String getGreeting() {
		return "Hello World - Constructor";
	}
}
