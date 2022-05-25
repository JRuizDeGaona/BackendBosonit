package com.formacion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase controladora con un método que muestra el valor de dos parámetros (URL y Password)
 */
@RestController
public class ValorFunciones {
    @Value("${propiedades.url}")
    String url;

    @Value("${propiedades.password}")
    String password;

    /**
     * Método que mostrará al usuario el valor de dos variables
     * @return Un String con el valor de dos variables
     */
    @GetMapping("/parametros")
    public String valorVariables() {
        return "URL: " + url + " | Password: " + password;
    }
}
