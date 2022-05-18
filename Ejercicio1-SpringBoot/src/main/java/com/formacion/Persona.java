package com.formacion;

public class Persona {
    private String nombre, ciudad;
    private int edad;

    public Persona(String nombre, int edad, String ciudad) {
        setNombre(nombre);
        setEdad(edad);
        setCiudad(ciudad);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | " + " Ciudad: " + ciudad + " | " + " Edad: " + (edad+1);
    }
}
