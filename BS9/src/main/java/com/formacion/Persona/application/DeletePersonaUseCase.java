package com.formacion.Persona.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Excepciones.UnprocessableEntityException;
import com.formacion.Persona.application.port.DeletePersonaPort;
import com.formacion.Persona.domain.Persona;
import com.formacion.Persona.infraestructure.repository.PersonaRepositorio;
import com.formacion.Profesor.infraestructure.repository.ProfesorRepositorio;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    StudentRepositorio studentRepositorio;
    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Override
    public void deletePersona(int id_persona) throws NotFoundException {
        Persona personaAux = personaRepositorio.findById(id_persona).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));
        boolean borrar = true;

        studentRepositorio.findAll().forEach(student -> {
            if (student.getPersona() != null) {
                if (id_persona == student.getPersona().getId_persona()) {
                    throw new UnprocessableEntityException("No se puede borrar una persona con un estudiante asignado");
                }
            }
        });

        profesorRepositorio.findAll().forEach(profesor -> {
            if (profesor.getPersona() != null) {
                if (id_persona == profesor.getPersona().getId_persona()) {
                    throw new UnprocessableEntityException("No se puede borrar una persona con un estudiante asignado");
                }
            }
        });

        personaRepositorio.deleteById(id_persona);
    }
}
