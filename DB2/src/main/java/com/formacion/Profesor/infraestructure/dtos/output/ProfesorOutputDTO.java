package com.formacion.Profesor.infraestructure.dtos.output;

import com.formacion.Persona.domain.Persona;
import com.formacion.Profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorOutputDTO {
    private Integer id_profesor;
    private Persona persona;
    private String coments;
    private String branch;
    private ProfesorOutputDTO profesor;

    public ProfesorOutputDTO(Profesor profesor){
        this.persona = profesor.getPersona();
        this.coments = profesor.getComents();
        this.branch = profesor.getBranch();
    }
}
