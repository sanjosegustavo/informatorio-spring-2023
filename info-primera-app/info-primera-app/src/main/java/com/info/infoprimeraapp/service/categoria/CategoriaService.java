package com.info.infoprimeraapp.service.categoria;


import com.info.infoprimeraapp.domain.Categoria;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Optional<Categoria> getCategoriaById(UUID id);
}
