package com.formacion.Ejercicio2SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class Controlador1 {
    //Conectamos con la clase Servicio
    @Autowired
    Servicio service;
    /**
     * Método del que devolvemos la Persona creada en la clae Servicio
     * @param person Mapa con @RequestHeader para los datos de la persona
     * @return Una Persona con los datos del método addPersona de la clase Servicio
     */
    @GetMapping("/controlador1/addPersona")
    public Persona addPersona(@RequestHeader Map<String, String> person) {
        return service.addPersona(person.get("nombre"), person.get("poblacion"), Integer.parseInt(person.get("edad")));
    }
}
