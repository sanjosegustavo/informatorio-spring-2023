package com.info.infoprimeraapp.mapper.categoria;

import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.model.dto.categoria.CategoriaDTO;

public interface CategoriaMapper {
    CategoriaDTO categoriaToCategoriaDTO(Categoria categoria);
}
