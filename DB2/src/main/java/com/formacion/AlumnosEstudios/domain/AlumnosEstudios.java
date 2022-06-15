package com.formacion.AlumnosEstudios.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.formacion.AlumnosEstudios.infraestructure.dto.input.AlumnosEstudiosInputDTO;
import com.formacion.Profesor.domain.Profesor;
import com.formacion.Student.domain.Student;
import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "estudios")
@Getter
@Setter
public class AlumnosEstudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_study;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profesor_id")
    Profesor profesor;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_student")
    Student student;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;

    public AlumnosEstudios() {
    }
    public AlumnosEstudios(AlumnosEstudiosInputDTO alumnosEstudios){
        setId_study(alumnosEstudios.getId_study());
        setAsignatura(alumnosEstudios.getAsignatura());
        setComment(alumnosEstudios.getComment());
        setInitial_date(alumnosEstudios.getInitial_date());
        setFinish_date(alumnosEstudios.getFinish_date());
    }

    public void update(AlumnosEstudiosInputDTO alumnosEstudios) {
        setAsignatura(alumnosEstudios.getAsignatura());
        setComment(alumnosEstudios.getComment());
        setInitial_date(alumnosEstudios.getInitial_date());
        setFinish_date(alumnosEstudios.getFinish_date());
    }
}
