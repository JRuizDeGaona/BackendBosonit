package com.formacion.Profesor.infraestructure.dtos.output;

import com.formacion.Profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleProfesorOutputDTO {
    private Integer id_profesor;
    private String coments;
    private String branch;
    private ProfesorOutputDTO profesor;

    public SimpleProfesorOutputDTO(Profesor profesor){
        this.coments = profesor.getComents();
        this.branch = profesor.getBranch();
    }
}
