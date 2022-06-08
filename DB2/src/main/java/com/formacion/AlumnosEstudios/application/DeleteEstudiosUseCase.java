package com.formacion.AlumnosEstudios.application;

import com.formacion.AlumnosEstudios.application.port.DeleteEstudiosPort;
import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.AlumnosEstudios.infraestructure.repository.AlumnosEstudiosRepositorio;
import com.formacion.Excepciones.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEstudiosUseCase implements DeleteEstudiosPort {
    @Autowired
    AlumnosEstudiosRepositorio alumnosEstudiosRepositorio;

    @Override
    public void deleteEstudios(int id_study) throws NotFoundException {
        AlumnosEstudios alumnosEstudios = alumnosEstudiosRepositorio.findById(id_study).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));

        alumnosEstudiosRepositorio.deleteById(id_study);
    }
}
