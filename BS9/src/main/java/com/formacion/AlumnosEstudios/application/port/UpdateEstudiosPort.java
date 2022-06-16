package com.formacion.AlumnosEstudios.application.port;

import com.formacion.AlumnosEstudios.infraestructure.dto.input.AlumnosEstudiosInputDTO;
import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;
import com.formacion.Excepciones.NotFoundException;

public interface UpdateEstudiosPort {
    AlumnosEstudiosOutputDTO updateEstudios(int id_study, AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) throws NotFoundException;
}
