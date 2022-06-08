package com.formacion.Persona.application;

import com.formacion.Excepciones.NotFoundException;
import com.formacion.Persona.application.port.DeletePersonaPort;
import com.formacion.Persona.domain.Persona;
import com.formacion.Persona.infraestructure.repository.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Override
    public void deletePersona(int id_persona) throws NotFoundException {
        Persona personaAux = personaRepositorio.findById(id_persona).orElseThrow(() -> new NotFoundException("El ID introducido no existe"));

        personaRepositorio.deleteById(id_persona);
    }
}
