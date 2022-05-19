package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador")
public class Controlador {
    @Autowired
    @Qualifier("bean1")
    Persona person1;

    @Autowired
    @Qualifier("bean2")
    Persona person2;

    @Autowired
    @Qualifier("bean3")
    Persona person3;

    @GetMapping("/bean/{nombre}")
    public String mostrarNombre(@PathVariable String nombre) {
        switch (nombre) {
            case "bean1":
                return person1.getNombre();
            case "bean2":
                return person2.getNombre();
            case "bean3":
                return person3.getNombre();
        }
        return "Nombre del @Bean no existente";
    }
}
