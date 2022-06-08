package com.formacion.AlumnosEstudios.infraestructure.dto.input;

import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Student.domain.Student;
import lombok.Data;

import java.util.Date;

@Data
public class AlumnosEstudiosInputDTO {
    int id_study;
    int id_profesor;
    int id_student;
    String asignatura;
    String comment;
    Date initial_date;
    Date finish_date;
}
