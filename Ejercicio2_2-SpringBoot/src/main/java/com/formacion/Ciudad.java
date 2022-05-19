package com.formacion;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Ciudad {
    private String nombre;
    private int numeroHabitantes;

    // Constructor por defecto
    public Ciudad() {
    }

    // Constructor parametrizado
    public Ciudad(String nombre, int numeroHabitantes) {
        setNombre(nombre);
        setNumeroHabitantes(numeroHabitantes);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }
    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }
}
