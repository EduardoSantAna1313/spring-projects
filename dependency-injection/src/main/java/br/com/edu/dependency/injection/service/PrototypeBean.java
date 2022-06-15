/**
 *
 */
package br.com.edu.dependency.injection.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author eduardo
 *
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

	public PrototypeBean() {
		super();
		System.out.println("Creating a prototype bean!");
	}

	public String getScope() {
		return "Prototype";
	}

}
