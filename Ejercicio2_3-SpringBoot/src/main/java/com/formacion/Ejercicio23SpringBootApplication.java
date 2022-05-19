package com.formacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio23SpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(Ejercicio23SpringBootApplication.class, args);
	}

	@Bean("bean1")
	public Persona Person1(){
		Persona person1 = new Persona();
		person1.setNombre("bean1");
		return person1;
	}
	@Bean ("bean2")
	public Persona Person2(){
		Persona person2 = new Persona();
		person2.setNombre("bean2");
		return person2;
	}
	@Bean("bean3")
	public Persona Person3(){
		Persona person3 = new Persona();
		person3.setNombre("bean3");
		return person3;
	}
}
