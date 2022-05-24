package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/persona")
@RestController
public class Controlador4 {

    @Autowired
    Servicio s;

    @GetMapping("/{id}")
    public Persona mostrarPersona(@PathVariable int id) {
        return s.consultarPersona(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Persona mostrarPersona(@PathVariable String nombre) {
        return s.consultarPersona(nombre);
    }
}
