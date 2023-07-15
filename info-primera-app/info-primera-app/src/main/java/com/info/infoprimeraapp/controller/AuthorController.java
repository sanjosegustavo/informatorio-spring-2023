package com.info.infoprimeraapp.controller;


import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class AuthorController {

    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //POST --> Crear un recurso
    @PostMapping("api/v1/author")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @DeleteMapping("/api/v1/author/{idAuthor}")
    public String deleteAuthor(@PathVariable(value = "idAuthor") UUID idAuthor){
        if (authorService.deleteAutor(idAuthor)) {
            return "Eliminado";
        }
        return "No se pudo eliminar";
    }

    @GetMapping("/api/v1/author/{nombre}/{apellido}")
    public Author getAuthor(@PathVariable(value = "nombre") String nombre, @PathVariable(value = "apellido") String apellido) {
        return authorService.getAuthor(nombre, apellido);
    }

    @GetMapping("/api/v1/author/{idAuthor}")
    public Author getAuthor(@PathVariable(value = "idAuthor") UUID idAuthor) {
        Optional<Author> authorOptional = authorService.getAuthor(idAuthor);
        if (authorOptional.isPresent()) {
            return authorOptional.get();
        }
        return null;
    }

}
