package com.formacion.BS4Ejercicio1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPropiedades {

    @Value("${VAR1}")
    String var1;

    @Value("${My.VAR2}")
    int var2;

    @Value("${VAR3: VAR3 no tiene ningún valor}")
    String var3;

    /**
     * Método que controla que muestra unos valores de dos variables ya definidas
     * @return String con los valores de las variables
     */
    @GetMapping("/valores")
    public String leerPropiedades() {
        return "Valor de var1 es: " + var1 + " valor de my.var2 es: " + var2;
    }

    /**
     * Método que lee el valor de una propiedad que no tiene valor específico
     * Le podemos poner el valor de la variable en el S.O "java -DVAR3=Hola -jar .\BS4-Ejercicio1-0.0.1-SNAPSHOT.jar"
     * @return String con el valor por defecto de esa variable
     */
    @GetMapping("/var3")
    public String leerPropiedadesVar3() {
        return var3;
    }
}
