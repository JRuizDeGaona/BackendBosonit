package com.formacion.domain;

import com.formacion.infraestructure.dtos.input.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import java.util.Date;
@Table(name = "Persona")
@Entity
@Data
@NoArgsConstructor
public class EntityPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    int id_persona;

    @NonNull
    @Column(name = "usuario")
    public String usuario;

    @NonNull
    @Column(name = "password")
    public String password;

    @NonNull
    @Column(name = "name")
    public String name;

    @NonNull
    @Column(name = "surname")
    public String surname;

    @NonNull
    @Column(name = "company_email")
    public String company_email;

    @NonNull
    @Column(name = "personal_email")
    public String personal_email;

    @NonNull
    @Column(name = "city")
    public String city;

    @NonNull
    @Column(name = "active")
    public boolean active;

    @NonNull
    @Column(name = "created_date")
    public Date created_date;

    @NonNull
    @Column(name = "imagen_url")
    public String imagen_url;

    @NonNull
    @Column(name = "termination_date")
    public Date termination_date;

    public EntityPersona(PersonaInputDTO personaInputDTO) {
        setId_persona(personaInputDTO.getId_persona());
        setUsuario(personaInputDTO.getUsuario());
        setPassword(personaInputDTO.getPassword());
        setName(personaInputDTO.getName());
        setSurname(personaInputDTO.getSurname());
        setCompany_email(personaInputDTO.getCompany_email());
        setPersonal_email(personaInputDTO.getPersonal_email());
        setCity(personaInputDTO.getCity());
        setActive(personaInputDTO.isActive());
        setCreated_date(personaInputDTO.getCreated_date());
        setImagen_url(personaInputDTO.getImagen_url());
        setTermination_date(personaInputDTO.getTermination_date());
    }

    public void actualizarDatos(PersonaInputDTO personaInputDTO) throws Exception {
        if (personaInputDTO.getUsuario() != null && personaInputDTO.getUsuario().length() <= 10 && personaInputDTO.getUsuario().length() >= 6) {
            setUsuario(personaInputDTO.getUsuario());
        }
        if (personaInputDTO.getName() != null) {
            setName(personaInputDTO.getName());
        }
        if (personaInputDTO.getPassword() != null) {
            setPassword(personaInputDTO.getPassword());
        }
        if (personaInputDTO.getCompany_email() != null) {
            setCompany_email(personaInputDTO.getCompany_email());
        }
        if (personaInputDTO.getPersonal_email() != null) {
            setPersonal_email(personaInputDTO.getPersonal_email());
        }
        if (personaInputDTO.getCity() != null) {
            setCity(personaInputDTO.getCity());
        }
        if (personaInputDTO.getSurname() != null) {
            setSurname(personaInputDTO.getSurname());
        }
        if (personaInputDTO.getImagen_url() != null) {
            setImagen_url(personaInputDTO.getImagen_url());
        }
    }
}
