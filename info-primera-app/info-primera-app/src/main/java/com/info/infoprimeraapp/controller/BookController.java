package com.info.infoprimeraapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Anotación a nivel de clase
public class BookController {

    //Get --> Obtener
    //http://localhost:8080/aplicacion/v1/despedida
    @GetMapping("/aplicacion/v1/despedida")  // Anotación a nivel de método
    public String adiosMundo() {
        return "Adios mundo.";
    }

    //http://localhost:8080/aplicacion/v1/saludo?nombre=Marcelo
    @GetMapping("/aplicacion/v1/saludo")
    public String holaMundo(@RequestParam(required = true, name = "nombre") String nombre) {
        // @RequestParam(required = true, name = "nombre") String nombre Anotación a nivel de atributo
        return "Hola " + nombre;
    }

}
