package com.formacion.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "Student")
@Entity
@Data
@NoArgsConstructor
public class EntityStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int id_student;

    @NotNull
    @Column(name = "branch")
    private String branch;

    @NotNull
    @Column(name = "num_hours_week")
    private int num_hours_week;

    @Column(name = "coments")
    private String coments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private EntityPersona id_persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private EntityProfesor miProfesor;

    @OneToMany(mappedBy = "studentAsig", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EntityEstudianteAsignatura> listaAsignaturas;
}
