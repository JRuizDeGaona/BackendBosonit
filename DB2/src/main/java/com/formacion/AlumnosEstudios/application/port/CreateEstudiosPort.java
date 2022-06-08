package com.formacion.AlumnosEstudios.application.port;

import com.formacion.AlumnosEstudios.infraestructure.dto.input.AlumnosEstudiosInputDTO;
import com.formacion.AlumnosEstudios.infraestructure.dto.output.AlumnosEstudiosOutputDTO;

public interface CreateEstudiosPort {
    AlumnosEstudiosOutputDTO addEstudios(AlumnosEstudiosInputDTO alumnosEstudiosInputDTO) throws Exception;
}
