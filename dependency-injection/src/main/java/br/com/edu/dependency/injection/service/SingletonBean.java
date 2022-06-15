/**
 *
 */
package br.com.edu.dependency.injection.service;

import org.springframework.stereotype.Component;

/**
 * @author eduardo
 *
 */
@Component
public class SingletonBean {

	public SingletonBean() {
		super();
		System.out.println("Creating a singleton bean!");
	}

	public String getScope() {
		return "Singleton";
	}

}
