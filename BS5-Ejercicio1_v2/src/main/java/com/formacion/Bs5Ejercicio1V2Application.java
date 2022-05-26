package com.formacion;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class Bs5Ejercicio1V2Application {
// EJERCICIO QUE MUESTRA POR CONSOLA TODOS LOS LOGS, PERO SOLO METE EN EL FICHERO LOS DE TIPO ERROR
	public static void main(String[] args) {
		SpringApplication.run(Bs5Ejercicio1V2Application.class, args);
		log.trace("------------MENSAJE DE TRACE------------");
		log.debug("------------MENSAJE DE DEBUG------------");
		log.info("------------MENSAJE DE INFO------------");
		log.warn("------------MENSAJE DE WARN------------");
		log.error("------------MENSAJE DE ERROR------------");
	}
}
