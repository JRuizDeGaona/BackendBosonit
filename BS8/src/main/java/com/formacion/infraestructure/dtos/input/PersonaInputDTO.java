package com.formacion.infraestructure.dtos.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class PersonaInputDTO {
    int id_persona;

    @NotEmpty(message = "El usuario no puede estar vacío")
    @Size(min = 6, max = 10, message = "La longitud debe estar entre 6 y 10 caracteres")
    String usuario;

    @NotEmpty(message = "La contraseña no puede estar vacía")
    String password;

    @NotEmpty(message = "El nombre no puede estar vacío")
    String name;

    @NotEmpty(message = "El apellido no puede estar vacío")
    String surname;

    @Email(message = "Email corporativo no válido")
    @NotEmpty(message = "El email corporativo no puede estar vacío")
    String company_email;

    @Email(message = "Email personal no válido")
    @NotEmpty(message = "El email personal no puede estar vacío")
    String personal_email;

    @NotEmpty(message = "La Ciudad no puede estar vacía")
    String city;

    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;
}
