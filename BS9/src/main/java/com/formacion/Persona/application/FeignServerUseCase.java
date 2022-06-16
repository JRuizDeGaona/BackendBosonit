package com.formacion.Persona.application;

import com.formacion.Persona.application.port.FeignServerPort;
import com.formacion.Profesor.application.port.ObtenerProfesorPort;
import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FeignServerUseCase implements FeignServerPort {
    @Autowired
    ObtenerProfesorPort obtenerProfesorPort;

    @Override
    public ResponseEntity<ProfesorOutputDTO> callServer(int id, String outputType) throws Exception {
        return ResponseEntity.ok(obtenerProfesorPort.buscarPorId(id, outputType));
    }
}
