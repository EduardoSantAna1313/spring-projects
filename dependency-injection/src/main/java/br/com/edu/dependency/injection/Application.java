package br.com.edu.dependency.injection;

import br.com.edu.dependency.injection.controllers.ConstructorController;
import br.com.edu.dependency.injection.controllers.MyController;
import br.com.edu.dependency.injection.controllers.PropertyInjectedController;
import br.com.edu.dependency.injection.controllers.SetterController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.out.println("********* Primary *********");
		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println(myController.sayHello());

		System.out.println("********* Setter *********");
		SetterController setterController=(SetterController)  ctx.getBean("setterController")	;
		System.out.println(setterController.getGreeting());

		System.out.println("********* Constructor *********");
		ConstructorController constructorController  = (ConstructorController) ctx.getBean("constructorController");
		System.out.println(constructorController.getGreeting());

		System.out.println("********* Property Injected *********");
		PropertyInjectedController propertyInjectedController  = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());
	}

}
