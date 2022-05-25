package com.formacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("Perfil2")
public class Perfil2 implements Perfiles {
    String perfil = "Perfil2";

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
