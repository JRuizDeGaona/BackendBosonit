package com.formacion.application.useCase;

import com.formacion.application.port.UpdatePersonaPort;
import com.formacion.domain.EntityPersona;
import com.formacion.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.exception.NotFoundException;
import com.formacion.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO updatePersona(int id_persona, PersonaInputDTO personaInputDTO) throws NotFoundException {
        EntityPersona persona = personaRepository.findById(id_persona).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));
        persona.actualizarDatos(personaInputDTO);

        personaRepository.save(persona);
        return new PersonaOutputDTO(persona);
    }
}
