package com.formacion.AlumnosEstudios.application;

import com.formacion.AlumnosEstudios.application.port.UpdateEstudiosPort;
import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.AlumnosEstudios.infraestructure.dto.input.AlumnosEstudiosInputDTO;
import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;
import com.formacion.AlumnosEstudios.infraestructure.repository.AlumnosEstudiosRepositorio;
import com.formacion.Excepciones.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEstudiosUseCase implements UpdateEstudiosPort {
    @Autowired
    AlumnosEstudiosRepositorio alumnosEstudiosRepositorio;

    @Override
    public AlumnosEstudiosOutputDTO updateEstudios(int id_study, AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) throws NotFoundException {
        AlumnosEstudios alumnosEstudios = alumnosEstudiosRepositorio.findById(id_study).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));
        alumnosEstudios.update(alumnosEstudiosInputDTO);

        alumnosEstudiosRepositorio.saveAndFlush(alumnosEstudios);
        return new AlumnosEstudiosOutputDTO(alumnosEstudios);
    }
}
