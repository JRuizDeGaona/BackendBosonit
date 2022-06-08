package com.formacion.AlumnosEstudios.infraestructure.dto.output;

import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Student.domain.Student;
import lombok.Data;

import java.util.Date;

@Data
public class AlumnosEstudiosOutputDTO {
    private int id_study;
    private Profesor profesor;
    private Student student;
    private String asignatura;
    private String comment;
    private Date initialDate;
    private Date finishDate;

    public AlumnosEstudiosOutputDTO(AlumnosEstudios alumnosEstudios) {
        setId_study(alumnosEstudios.getId_study());
        setProfesor(alumnosEstudios.getProfesor());
        setStudent(alumnosEstudios.getStudent());
        setAsignatura(alumnosEstudios.getAsignatura());
        setComment(alumnosEstudios.getComment());
        setInitialDate(alumnosEstudios.getInitial_date());
        setFinishDate(alumnosEstudios.getFinish_date());
    }
}
