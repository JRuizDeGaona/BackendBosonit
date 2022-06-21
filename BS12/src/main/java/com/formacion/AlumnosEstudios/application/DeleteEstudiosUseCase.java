package com.formacion.AlumnosEstudios.application;

import com.formacion.AlumnosEstudios.application.port.DeleteEstudiosPort;
import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.AlumnosEstudios.infraestructure.repository.AlumnosEstudiosRepositorio;
import com.formacion.Excepciones.NotFoundException;
import com.formacion.Excepciones.UnprocessableEntityException;
import com.formacion.Student.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEstudiosUseCase implements DeleteEstudiosPort {
    @Autowired
    AlumnosEstudiosRepositorio alumnosEstudiosRepositorio;
    @Autowired
    StudentRepositorio studentRepositorio;

    @Override
    public void deleteEstudios(int id_study) throws NotFoundException {
        AlumnosEstudios alumnosEstudiosAux = alumnosEstudiosRepositorio.findById(id_study).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));

        alumnosEstudiosRepositorio.findAll().forEach(alumnosEstudios -> {
            if (alumnosEstudios.getStudent() == null) {
                alumnosEstudiosRepositorio.deleteById(id_study);
            } else {
                throw new UnprocessableEntityException("No se puede borrar una asignatra con estudiante asignado");
            }
        });
    }
}
