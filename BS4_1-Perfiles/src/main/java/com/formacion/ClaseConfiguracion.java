package com.formacion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Configuration
@RestController
@PropertySource("classpath:miconfiguracion.properties")
public class ClaseConfiguracion {

    @Value("${nombre}")
    String nombre;

    @Value("${apellido}")
    String apellido;

    /**
     * Método que devuelve por postman el valor de las variables
     * @return String con el valor de las variables concatenado
     */
    @GetMapping("/miconfiguracion")
    public String devolverVariable() {
        return nombre + " " + apellido;
    }

    /**
     * Método que muestra por consola el valor de las variables al arrancar el programa
     */
    @PostConstruct
    public void mostrarVariable() {
        System.out.println(devolverVariable());
    }
}
