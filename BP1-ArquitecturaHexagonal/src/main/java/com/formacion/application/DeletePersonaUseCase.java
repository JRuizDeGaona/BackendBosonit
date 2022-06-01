package com.formacion.application;

import com.formacion.application.port.DeletePersonaPort;
import com.formacion.domain.EntityPersona;
import com.formacion.infraestructure.dtos.output.PersonaOutputDTO;
import com.formacion.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void deletePersona(int id_persona) throws Exception {
        EntityPersona personaAux;
        PersonaOutputDTO persona;

        personaAux = personaRepository.findById(id_persona).orElseThrow(() -> new Exception());//406
        persona = new PersonaOutputDTO(personaAux);

        if(persona == null){
            throw new Exception("No hay usuarios");
        }else{
            personaRepository.deleteById(id_persona);
        }
    }
}
