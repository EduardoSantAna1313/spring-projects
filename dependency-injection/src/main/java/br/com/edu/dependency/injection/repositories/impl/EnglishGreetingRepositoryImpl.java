/**
 * 
 */
package br.com.edu.dependency.injection.repositories.impl;

import br.com.edu.dependency.injection.repositories.EnglishGreetingRepository;

/**
 * @author eduardo
 *
 */
public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

	@Override
	public String getGreeting() {
		return "Hello World from English repository - EN";
	}
}
