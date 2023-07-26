package com.info.infoprimeraapp.service.categoria;


import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.model.dto.categoria.CategoriaDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriaService {
    List<CategoriaDTO> getAllCategorias();
    Optional<CategoriaDTO> getCategoriaById(UUID id);
}
