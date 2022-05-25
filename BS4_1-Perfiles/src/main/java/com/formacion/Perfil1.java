package com.formacion;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("Perfil1")
public class Perfil1 implements Perfiles {
    String perfil = "Perfil1";

    /**
     * Método que muestra por pantalla el nombre del perfil activo
     * @return Un String con el nombre del perfil activo
     */
    @Override
    public String MiPerfil() {
        System.out.println(perfil);
        return perfil;
    }
}
