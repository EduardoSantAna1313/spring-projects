package br.com.edu.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Start application.
 * 
 * @author Eduardo
 *
 */
@SpringBootApplication
@EntityScan(basePackages = { "br.com.edu.start.model" })
@ComponentScan(basePackages = { "br.com.edu.start.controller", "br.com.edu.start.service" })
@EnableJpaRepositories(basePackages = { "br.com.edu.start.repository" })
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

}
