package com.formacion.SpringParte1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
    /**
     * Método que devuelve un Hola Mundo en SpringBoot
     *
     * @return Hola Mundo
     */
    @GetMapping("/holamundo")
    public String HolaMundo() {
        return ("Hola Mundo");
    }

    /**
     * Método que busca entre todos nuestros trabajadores y nos dice si el id de ese trabajdor existe
     *
     * @param id Identificador del trabajaodr que quermos buscar
     * @return Un String especificando si el id existe o no
     */
    @GetMapping("/estrabajador/{id}")
    public String EsTrabajador(@PathVariable int id) {
        int[] trabajadores = new int[]{1, 2, 3, 4, 5};
        boolean flag = false;

        for (int i = 0; i < trabajadores.length; i++) {
            if (id == trabajadores[i]) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        if (flag) {
            return "El trabajador con id: " + id + " sí existe";
        } else {
            return "No hay ningún trabajador con el id: " + id;
        }
    }

    /**
     * Método que permite no meter un id, es decir, el parámetro no es obligatorio
     * @param id parámetro id que pasamos o no
     * @return Un String que nos especifica si hemos pasado un parámetro o no
     */
    @GetMapping(value = {"/conid", "/conid/{id}"})
    public String HayId(@PathVariable(required = false) String id) {
        if (id != null) {
            return "El ID introducido es: "+id;
        } else {
            return "No has introducido ID";
        }
    }
}