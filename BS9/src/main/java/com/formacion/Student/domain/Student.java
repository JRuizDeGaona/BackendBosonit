package com.formacion.Student.domain;

import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import com.formacion.AlumnosEstudios.domain.AlumnosEstudios;
import com.formacion.Persona.domain.Persona;
import com.formacion.Profesor.domain.Profesor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_student;
    @OneToOne
    @JoinColumn(name="id_persona")
    Persona persona;
    @Column(name="num_hours_week")
    Integer num_hours_week;
    @Column(name="coments")
    String coments;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_profesor")
    Profesor profesor;
    @Column(name="branch")
    String branch;
    @OneToMany
    List<AlumnosEstudios> estudios;

    public Student() {
    }

    /**
     * Constructor que recibe un StudentInputDTO para inicializar un estudiante
     * @param studentInputDTO Los datos del estudiante
     */
    public Student (StudentInputDTO studentInputDTO) {
        setId_student(studentInputDTO.getId_student());
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setComents(studentInputDTO.getComents());
        setBranch(studentInputDTO.getBranch());
        setEstudios(studentInputDTO.getEstudios());
    }

    /**
     * Método para actualizar los datos del estudiante
     * @param studentInputDTO
     */
    public void update(StudentInputDTO studentInputDTO) {
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setComents(studentInputDTO.getComents());
        setBranch(studentInputDTO.getBranch());
        setEstudios(studentInputDTO.getEstudios());
    }
}
