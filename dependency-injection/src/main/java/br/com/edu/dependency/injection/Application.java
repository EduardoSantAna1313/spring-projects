package br.com.edu.dependency.injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import br.com.edu.dependency.injection.controllers.ConstructorController;
import br.com.edu.dependency.injection.controllers.I18nController;
import br.com.edu.dependency.injection.controllers.MyController;
import br.com.edu.dependency.injection.controllers.PetController;
import br.com.edu.dependency.injection.controllers.PropertyInjectedController;
import br.com.edu.dependency.injection.controllers.SetterController;

@ComponentScan(basePackages = { "br.com.edu.dependency.injection" })
@SpringBootApplication
public class Application {

	public static void main(final String[] args) {
		final ApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.out.println("********* Primary *********");
		final MyController myController = (MyController) ctx.getBean("myController");
		System.out.println(myController.sayHello());

		System.out.println("********* Setter *********");
		final SetterController setterController = (SetterController) ctx.getBean("setterController");
		System.out.println(setterController.getGreeting());

		System.out.println("********* Constructor *********");
		final ConstructorController constructorController = (ConstructorController) ctx
				.getBean("constructorController");
		System.out.println(constructorController.getGreeting());

		System.out.println("********* Property Injected *********");
		final PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("********* Profile Controller Injected *********");
		final I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayGreeting());

		System.out.println("******** Pet Controller with multiple profiles *****");
		final PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.whichIsTheBest());
	}

}
