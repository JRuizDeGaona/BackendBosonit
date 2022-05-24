package com.formacion;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Servicio {
    private ArrayList<Persona> listaPersona = new ArrayList<>();

    /**
     * Método que añade una persona a una lista
     * @param p Objeto persona que queremos añadir
     * @return Lista de las personas con la nueva persona añadida
     */
    public List añadirPersona(Persona p) {
        listaPersona.add(p);
        return listaPersona;
    }

    /**
     * Método para modificar los datos de una persona
     * @param id ID de la persona que queremos modificar
     * @return Lista de personas con los datos ya modificados
     */
    public List modificarPersona(int id, Map<String, String> mapa) {
        for (int index = 0; index < listaPersona.size(); index++) {
            if (listaPersona.get(index).getId() == id) {
                if (mapa.get("nombre") != null) {
                    listaPersona.get(index).setNombre(mapa.get("nombre"));
                }
                if (mapa.get("poblacion") != null) {
                    listaPersona.get(index).setPoblacion(mapa.get("poblacion"));
                }
                if (Integer.parseInt(mapa.get("edad")) != 0) {
                    listaPersona.get(index).setEdad(Integer.parseInt(mapa.get("edad")));
                }
            }
        }
        return listaPersona;
    }

    /**
     * Método que elimina una persona de una lista por el ID de ésta
     * @param id ID de la persona que queremos eliminar
     * @return Lista de las personas
     */
    public List borrarPersona(int id) {
        for (int index = 0; index < listaPersona.size(); index++) {
            if (listaPersona.get(index).getId() == id) {
                listaPersona.remove(index);
                return listaPersona;
            }
        }
        return listaPersona;
    }

    /**
     * Método que muestra una persona por su ID
     * @param id ID de la persona que queremos mostrar
     * @return String con los datos de la Persona
     */
    public Persona consultarPersona(int id) {
        for (int index = 0; index < listaPersona.size(); index++) {
            if (listaPersona.get(index).getId() == id) {
                return listaPersona.get(index);
            }
        }
        return listaPersona.get(0);
    }

    /**
     * Método que muestra una Persona por su nombre
     * @param nombre Nonbre de la persona que queremos buscar
     * @return String con los datos de la persona
     */
    public Persona consultarPersona(String nombre) {
        for (int index = 0; index < listaPersona.size(); index++) {
            if (listaPersona.get(index).getNombre().equalsIgnoreCase(nombre)) {
               return listaPersona.get(index);
            }
        }
        return listaPersona.get(0);
    }
}
