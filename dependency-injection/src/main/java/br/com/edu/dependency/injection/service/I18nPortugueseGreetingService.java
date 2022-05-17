package br.com.edu.dependency.injection.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"PT", "default"}) // Default profile, does not need to configure spring.profiles.active on application.properties
@Service("i18nService")
public class I18nPortugueseGreetingService implements GreetingService{
    @Override
    public String getGreeting() {
        return "Olá Mundo - PT";
    }
}
