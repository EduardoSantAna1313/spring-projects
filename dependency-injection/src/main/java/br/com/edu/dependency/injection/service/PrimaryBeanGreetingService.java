package br.com.edu.dependency.injection.service;

public class PrimaryBeanGreetingService implements GreetingService {

	@Override
	public String getGreeting() {
		return "Hello World - Primary bean";
	}

}
