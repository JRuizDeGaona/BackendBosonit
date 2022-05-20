package com.formacion.Ejercicio3SpringBoot.RS1;

import org.springframework.stereotype.Component;

@Component
public class Usuario {
    private String nombre;
    private int id;

    public Usuario() {
    }

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\t" + " | Id: " + id;
    }
}
