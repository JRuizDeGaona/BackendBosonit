package com.formacion;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PrimeraClase {

    /**
     * Este método se ejecutará el primero siempre por la etiqueta @PostConstruct
     */
    @PostConstruct
    public void mostrarMensaje() {
        System.out.println("Hola desde la clase inicial");
    }

    /**
     * Este método sirve para cerrar el Bean una vez se para el programa, mostrará un mensaje "FINAL"
     */
    @PreDestroy
    public void mostrarMensaje2() {
        System.out.println("FINAL");
    }
}
