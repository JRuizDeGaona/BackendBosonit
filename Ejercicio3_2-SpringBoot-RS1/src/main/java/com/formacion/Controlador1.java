package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/persona")
@RestController
public class Controlador1 {

    @Autowired
    Servicio s;

    @PostMapping
    public List añadirPersona(@RequestBody Persona p) {
        return s.añadirPersona(p);
    }
}
