package com.example.ecommercespring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceSpringApplication {

	public static void main(String[] args) {

		//load environment variables from .env file
		Dotenv dotenv = Dotenv.configure().load();

		//get system properties from environment variables and set them
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(),entry.getValue()));

		SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
