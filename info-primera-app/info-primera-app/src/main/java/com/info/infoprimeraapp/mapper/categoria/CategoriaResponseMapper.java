package com.info.infoprimeraapp.mapper.categoria;

import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.model.dto.categoria.CategoriaDTO;
import com.info.infoprimeraapp.model.dto.categoria.CategoriaResponseDTO;

public interface CategoriaResponseMapper {

    CategoriaResponseDTO categoriaToCategoriaResponseDTO(Categoria categoria);
}
