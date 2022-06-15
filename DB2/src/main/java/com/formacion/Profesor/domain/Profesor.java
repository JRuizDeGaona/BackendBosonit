package com.formacion.Profesor.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.formacion.Profesor.infraestructure.dtos.input.ProfesorInputDTO;
import com.formacion.Persona.domain.Persona;
import com.formacion.Student.infraestructure.dtos.input.StudentInputDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name = "profesor")
@Getter
@Setter
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_profesor;

    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;

    public Profesor(){
    }

    public Profesor(ProfesorInputDTO profesorDTO){
        setId_profesor(profesorDTO.getId_profesor());
        setComents(profesorDTO.getComents());
        setBranch(profesorDTO.getBranch());
    }

    public void update(ProfesorInputDTO profesorInputDTO) {
        setComents(profesorInputDTO.getComents());
        setBranch(profesorInputDTO.getBranch());
    }
}
