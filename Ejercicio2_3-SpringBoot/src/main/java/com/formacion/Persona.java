package com.formacion;

public class Persona {
    private String nombre;

    public Persona(){

    }
    public Persona(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
