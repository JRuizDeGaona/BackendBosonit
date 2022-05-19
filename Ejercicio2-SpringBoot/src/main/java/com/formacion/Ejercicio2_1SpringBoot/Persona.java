package com.formacion.Ejercicio2_1SpringBoot;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    private String nombre, poblacion;
    private int edad;

    // Constructores
    public Persona() {
    }

    public Persona(String nombre, String poblacion, String edad) {
        setNombre(nombre);
        setPoblacion(poblacion);
        setEdad(Integer.parseInt(edad));
    }

    // Getters y Setters
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

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" + "Poblacion: " + poblacion + "\n" + "Edad: " + edad ;
    }
}
