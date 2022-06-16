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

    public ProfesorOutputDTO(Profesor profesor){
        setId_profesor(profesor.getId_profesor());
        this.persona = profesor.getPersona();
        this.coments = profesor.getComents();
        this.branch = profesor.getBranch();
    }
}
