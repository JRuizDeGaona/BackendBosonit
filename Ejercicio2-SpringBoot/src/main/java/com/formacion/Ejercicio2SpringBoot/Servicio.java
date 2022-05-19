package com.formacion.Ejercicio2SpringBoot;

import org.springframework.stereotype.Service;

@Service
public class Servicio {
    Persona p = new Persona();

    /**
     * Método para añadir una Persona
     * @param nombre Nombre de la persona
     * @param poblacion Poblacion de la persona
     * @param edad Edad de la persona
     * @return Persona con datos
     */
    public Persona addPersona(String nombre, String poblacion, int edad) {
        p.setNombre(nombre);
        p.setPoblacion(poblacion);
        p.setEdad(edad);
        return p;
    }

    /**
     * Método que multiplica la edad de una persona y te muestra sus datos
     * @return Persona con la edad multiplicada por dos
     */
    public Persona getPersona() {
        p.setEdad(p.getEdad()*2);
        return p;
    }
}
