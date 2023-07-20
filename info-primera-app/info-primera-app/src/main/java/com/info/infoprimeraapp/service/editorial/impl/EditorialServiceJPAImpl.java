package com.info.infoprimeraapp.service.editorial.impl;

import com.info.infoprimeraapp.domain.Editorial;
import com.info.infoprimeraapp.repository.editorial.EditorialRepository;
import com.info.infoprimeraapp.service.editorial.EditorialService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class EditorialServiceJPAImpl implements EditorialService {

    private final EditorialRepository editorialRepository;


    @Override
    public List<Editorial> getAllEditorial() {
        return editorialRepository.findAll(); // Devuelve todas las editoriales
    }

    @Override
    public Editorial createEditorial(Editorial editorial) {
        editorial.setId(UUID.randomUUID());
        return editorialRepository.save(editorial); // Guardar en la base de datos
    }

    @Override
    public Editorial getEditorial(String title) {
        return null;
    }

    @Override
    public Optional<Editorial> updateEditorial(UUID uuidEditorial, Editorial editorialUpdated) {
        // Buscar editorial por ID
        Optional<Editorial> editorialOptional = editorialRepository.findById(uuidEditorial);

        if(editorialOptional.isPresent()){
            updatingEditorial(editorialOptional.get(), editorialUpdated);
            //Save --> Si existe entonces la actualiza  y si no la crea
            return Optional.of(editorialRepository.save(editorialOptional.get()));

        }else{
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteEditorial(UUID uuidEditorial) {
        if (editorialRepository.findById(uuidEditorial).isPresent()) {
            editorialRepository.deleteById(uuidEditorial);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Editorial> getEditorialById(UUID uuidEditorial) {
        return Optional.of(editorialRepository.findById(uuidEditorial)).orElse(null);
    }


    private void updatingEditorial(Editorial editorial, Editorial editorialUpdated){
        if (editorialUpdated.getNombre() != null){
            editorial.setNombre(editorialUpdated.getNombre());
        }

        if (editorialUpdated.getDireccion() != null){
            editorial.setDireccion(editorialUpdated.getDireccion());
        }

        if (editorialUpdated.getCiudad() != null){
            editorial.setCiudad(editorialUpdated.getCiudad());
        }

        if (editorialUpdated.getPais() != null){
            editorial.setPais(editorialUpdated.getPais());
        }

        if (editorialUpdated.getTelefono() != null){
            editorial.setTelefono(editorialUpdated.getTelefono());
        }

        if (editorialUpdated.getSitioWeb() != null){
            editorial.setSitioWeb(editorialUpdated.getSitioWeb());
        }

    }
}
