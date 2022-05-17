package br.com.edu.dependency.injection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryBeanGreetingService implements GreetingService{

    @Override
    public String getGreeting() {
        return "Hello WOrld - Primary bean";
    }
}
