package com.formacion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bs3SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bs3SpringBootApplication.class, args);
	}

	/**
	 * Bean que le pasamos los args a todos los métodos que tengan la clase CommandLineRunner
	 * @return
	 */
	@Bean
	CommandLineRunner ejecutate(){
		return p -> System.out.println("Linea a ejecutar cuando arranque");
	}
}
