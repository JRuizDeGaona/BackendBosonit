package com.formacion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SegundaClase implements CommandLineRunner {

    /**
     * Método que muestra un mensaje diciendo que es la segunda clase
     * @param args Argumentos pasados desde la clase Main
     * @throws Exception Un error
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde la clase secundaria");
    }
}
