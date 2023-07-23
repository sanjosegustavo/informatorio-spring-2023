package com.info.infoprimeraapp.controller;


import com.info.infoprimeraapp.domain.Editorial;
import com.info.infoprimeraapp.domain.Resena;
import com.info.infoprimeraapp.service.resena.ResenaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resena")
@Slf4j
public class ResenaController {

    ResenaService resenaService;

    @Autowired
    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping()
    public List<Resena> getAllResenas() {
        log.info("Se esta haciendo una consulta por todas las reseñas.");
        return resenaService.getAllResenas();
    }
}
