package com.formacion.Ejercicio3SpringBoot.RS1;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/controlador1")
public class Controlador {
    private String bienvenida = "Bienvendi@!, tu id de usuario es: ";

    /**
     * Método que da la bienvenida a un Usuario mostrándole su id
     * @param id Id del usuario
     * @return Un String con el mensaje de bienvenida
     */
    @GetMapping("/user/{id}")
    public String getBienvenida(@PathVariable int id) {
        return bienvenida + id;
    }

    /**
     * Método que muestra un JSON con el Usuario
     * @param uwu Usuario a mostrar
     * @return Usuario recibido por parámetro que se muestra en un JSON
     */
    @PostMapping("/user")
    public Usuario getUsuario(@RequestBody Usuario uwu) {
        return uwu;
    }

    /**
     * Método que muestra un usuario ID, Nombre por PUT
     * @param map Con la clave (id) y el valor (nombre)
     * @return Un string del mapa
     */
    @PutMapping("/user/put")
    public String putUsuario(@RequestParam Map<String, String> map) {
        return map.toString();
    }
}
