package com.formacion.Profesor.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Profesor.application.port.DeleteProfesorPort;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfesorUseCase implements DeleteProfesorPort {
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Override
    public void deletePorfesor(int id_profesor) throws NotFoundException {
        Profesor profesor;
        profesor = profesorRepositorio.findById(id_profesor).orElseThrow(() -> new NotFoundException("ID no encontrado"));

        profesorRepositorio.deleteById(id_profesor);
    }
}
