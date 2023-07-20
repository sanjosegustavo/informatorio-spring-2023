package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Editorial;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.service.editorial.EditorialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/editorial") // Todos los endpoints comparten esta URI
@Slf4j
public class EditorialController {

    //IoC Inversión de control
    EditorialService editorialService;

    @Autowired
    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping()
    public List<Editorial> getAllEditorial() {
        log.info("Se esta haciendo una consulta por todas las editoriales.");
        return editorialService.getAllEditorial();
    }

    @GetMapping("/{idEditorial}")
    public Editorial getEditorialById(@PathVariable(value = "idEditorial") UUID idEditorial) throws NotFoundException {
        return editorialService.getEditorialById(idEditorial).orElseThrow(NotFoundException::new);
    }

    @PostMapping()
    public ResponseEntity createBook(@RequestBody Editorial editorial) {
        log.info("Creación de una nueva Editorial");
        Editorial editorialCreated = editorialService.createEditorial(editorial);

        HttpHeaders headers = new HttpHeaders(); // cabecera de la respuesta
        headers.add("Location", "/api/v1/editorial/" + editorialCreated.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{idEditorial}")
    public ResponseEntity updateBook(@PathVariable(value = "idEditorial")UUID idEditorial, @RequestBody Editorial editorialUpdated)
            throws NotFoundException {
        Optional<Editorial> editorial = editorialService.updateEditorial(idEditorial, editorialUpdated);

        if (editorial.isEmpty()){
            log.info("Editorial no encontrada");
            throw new NotFoundException();
        } else {
            log.info("Editorial actualizada");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{idEditorial}")
    public ResponseEntity deleteBook(@PathVariable(value = "idEditorial") UUID idEditorial) throws NotFoundException {
        boolean isEditorialDeleted = editorialService.deleteEditorial(idEditorial);
        if (isEditorialDeleted){
            log.info("Editorial eliminada.");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        log.info("Editorial no encontrada.");
        throw new NotFoundException();
    }


}
