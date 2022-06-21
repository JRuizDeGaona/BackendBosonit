package com.formacion.Persona.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Persona.application.port.UpdatePersonaPort;
import com.formacion.Persona.domain.Persona;
import com.formacion.Persona.infraestructure.dtos.input.PersonaInputDTO;
import com.formacion.Persona.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.Persona.infraestructure.repository.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public PersonaOutputDTO updatePersona(int id_persona, PersonaInputDTO personaInputDTO) throws NotFoundException {
        Persona persona = personaRepositorio.findById(id_persona).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));
        persona.actualizarDatos(personaInputDTO);

        personaRepositorio.save(persona);
        return new PersonaOutputDTO(persona);
    }
}
