package com.formacion.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "estudiante_asignatura")
@Entity
public class EntityEstudianteAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private int id_asignatura;

    @Column(name = "asignatura")
    private String asignatura;

    @Column(name = "coments")
    private String coments;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "initial_date")
    private Date initial_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "finish_date")
    private Date finish_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private EntityStudent studentAsig;
}