package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class TerceraClase implements CommandLineRunner {

    /**
     * Método que muestra un mensaje diciendo que es la tercera clase
     * @param args Argumentos pasados desde la clase Main
     * @throws Exception Un error
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase");
        for (String msg: args) {
           System.out.println(msg);
        }
    }
}
