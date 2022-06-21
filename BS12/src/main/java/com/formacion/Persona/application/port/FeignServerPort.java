package com.formacion.Persona.application.port;

import com.formacion.Profesor.infraestructure.dtos.output.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FeignServer", url = "https://localhost:8080")
public interface FeignServerPort {
    ResponseEntity<ProfesorOutputDTO> callServer(int id, String outputType) throws Exception;
}
