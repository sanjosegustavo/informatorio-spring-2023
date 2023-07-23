package com.info.infoprimeraapp.service.resena;

import com.info.infoprimeraapp.domain.Resena;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ResenaService {

    List<Resena> getAllResenas();

    Optional<Resena> getResenaById(UUID id);

    Resena createResena(Resena resena);

    Optional<Resena> updateResena(UUID id, Resena resenaUpdated);

    boolean deleteResena(UUID id);

}
