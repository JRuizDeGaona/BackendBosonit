package com.formacion.application;

import com.formacion.application.port.DeletePersonaPort;
import com.formacion.domain.EntityPersona;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void deletePersona(int id_persona) throws Exception {
        EntityPersona personaAux;
        personaAux = personaRepository.findById(id_persona).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE));//406

        personaRepository.deleteById(id_persona);

    }
}
