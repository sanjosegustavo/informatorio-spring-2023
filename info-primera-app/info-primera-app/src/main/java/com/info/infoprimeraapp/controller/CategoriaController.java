package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.service.categoria.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categoria")
@Slf4j
public class CategoriaController {

    CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public List<Categoria> getAllCategorias() {
        log.info("Consultando por todas las categorías.");
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/{idCategoria}")
    public Categoria getCategoriaById(@PathVariable(value = "idCategoria")UUID idCategoria) throws NotFoundException {
        return categoriaService.getCategoriaById(idCategoria).orElseThrow(NotFoundException::new);
    }
}
