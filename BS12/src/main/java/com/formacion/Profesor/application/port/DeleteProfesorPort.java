package com.formacion.Profesor.application.port;

import com.formacion.Excepciones.NotFoundException;

public interface DeleteProfesorPort {
    void deletePorfesor(int id_profesor) throws NotFoundException;
}
