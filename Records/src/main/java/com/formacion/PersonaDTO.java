package com.formacion;

import java.util.Date;
public record PersonaDTO(int id_persona, String usuario, String password, String name, String surname, String company_email, String personal_email, String city, Boolean active, Date created_date, String imagen_url, Date termination_date) {

    public PersonaDTO(int id_persona, String usuario, String password, String name, String surname, String company_email, String personal_email, String city, Boolean active, Date created_date, String imagen_url, Date termination_date) {
        this.id_persona = id_persona;
        this.usuario = usuario;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
    }

    public int id_persona() {return id_persona;}
    public String usuario() {return usuario;}
    public String password() {return password;}
    public String name() {return name;}
    public String surname() {return surname;}
    public String company_email() {return company_email;}
    public String personal_email() {return personal_email;}
    public String city() {return city;}
    public Boolean active() {return active;}
    public Date created_date() {return created_date;}
    public String imagen_url() {return imagen_url;}
    public Date termination_date() {return termination_date;}
}