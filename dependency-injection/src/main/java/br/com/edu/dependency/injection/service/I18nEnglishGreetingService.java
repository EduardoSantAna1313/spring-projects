package br.com.edu.dependency.injection.service;

import br.com.edu.dependency.injection.repositories.EnglishGreetingRepository;

public class I18nEnglishGreetingService implements GreetingService {

	private final EnglishGreetingRepository englishGreetingRepository;

	public I18nEnglishGreetingService(final EnglishGreetingRepository englishGreetingRepository) {
		super();
		this.englishGreetingRepository = englishGreetingRepository;
	}

	@Override
	public String getGreeting() {
		return englishGreetingRepository.getGreeting();
	}
}
