package com.formacion;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_persona;

    @Column(name = "usuario")
    @NotNull
    private String usuario;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "company_email")
    @NotNull
    private String company_email;

    @Column(name = "personal_email")
    @NotNull
    private String personal_email;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @Column(name = "created_date")
    @NotNull
    private Date created_date;

    @Column(name = "imagen_url")
    private String imagen_url;

    @Column(name = "termination_date")
    private Date termination_date;

    public Persona() {

    }
}
