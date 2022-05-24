package com.formacion;

public class Persona {
    private String nombre, poblacion;
    private int edad, id;

    public Persona() {
    }

    public Persona(String nombre, String poblacion, int edad, int id) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | " + "Población: " + poblacion + " | " + "Edad: " + edad + " | " + "ID: "+id;
    }
}
