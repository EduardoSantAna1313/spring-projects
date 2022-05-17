package br.com.edu.dependency.injection.service;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello World - Setter";
    }
}
