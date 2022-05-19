package com.formacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ejercicio22SpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio22SpringBootApplication.class, args);
	}
	@Bean
	public ArrayList<Ciudad> listaCiudad () {
		ArrayList<Ciudad> lista = new ArrayList<>();
		return lista;
	}
}
