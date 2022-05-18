package com.formacion;

import org.springframework.web.bind.annotation.*;

@RestController
public class Ejercicio1 {
    /**
     * Método que recibe un nombre y devuelve un saludo
     *
     * @param nombre nombre de la persona que queremos saludar
     * @return String que contiene "Hola " + el @param
     */
    @GetMapping("/hola/{nombre}")
    public String holaNombre(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    /**
     * Método que recibe por POST un objeto Persona mandado por JSON
     * @param p El objeto de tipo Persona
     * @return Devuelve un String con la información de la persona
     */
    @PostMapping("/useradd")
    public String userAdd(@RequestBody Persona p) {
        return p.toString();
    }
}
