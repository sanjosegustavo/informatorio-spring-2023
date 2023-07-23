package com.info.infoprimeraapp.service.resena.impl;


import com.info.infoprimeraapp.domain.Resena;
import com.info.infoprimeraapp.repository.resena.ResenaRepository;
import com.info.infoprimeraapp.service.resena.ResenaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ResenaServiceJPAImpl implements ResenaService {
    
    private final ResenaRepository resenaRepository; 


    @Override
    public List<Resena> getAllResenas() {
        return resenaRepository.findAll();
    }

    @Override
    public Optional<Resena> getResenaById(UUID id) {
        return Optional.of(resenaRepository.findById(id)).orElse(null);
    }

    @Override
    public Resena createResena(Resena resena) {
        resena.setId(UUID.randomUUID());
        return resenaRepository.save(resena);
    }

    @Override
    public Optional<Resena> updateResena(UUID id, Resena resenaUpdated) {
        Optional<Resena> optionalResena = resenaRepository.findById(id);
        
        if (optionalResena.isPresent()) {
            updatingResena(optionalResena.get(), resenaUpdated);
            return Optional.of(resenaRepository.save(optionalResena.get()));
        }
        return Optional.empty();
    }
    
    @Override
    public boolean deleteResena(UUID id) {
        if (resenaRepository.findById(id).isPresent()) {
            resenaRepository.deleteById(id);
            return true;
        }
        return false;
    }


    private void updatingResena(Resena resena, Resena resenaUpdated) {
        if (resenaUpdated.getTitulo() != null){
            resena.setTitulo(resenaUpdated.getTitulo());
        }

        if (resenaUpdated.getNombreLibro() != null){
            resena.setNombreLibro(resenaUpdated.getNombreLibro());
        }

        if (resenaUpdated.getContenido() != null){
            resena.setContenido(resenaUpdated.getContenido());
        }

        try {
            resena.setCalificacion(resenaUpdated.getCalificacion());
        } catch (Exception ignored) {
        }

        if (resenaUpdated.getFechaCreacion() != null){
            resena.setFechaCreacion(resenaUpdated.getFechaCreacion());
        }
    }
}
