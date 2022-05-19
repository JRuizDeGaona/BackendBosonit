package com.formacion.Ejercicio2SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {
    @Autowired
    Servicio service;

    /**
     * Método que nos devuelve la información de una persona
     * @return Los datos de una Persona llamando al método getPersona de la clase Servicio (Con la edad multiplicada *2)
     */
    @GetMapping("/controlador2/getPersona")
    public Persona getPersona() {
        Persona p = service.getPersona();
        p.setEdad(p.getEdad());
        return p;
    }
}
