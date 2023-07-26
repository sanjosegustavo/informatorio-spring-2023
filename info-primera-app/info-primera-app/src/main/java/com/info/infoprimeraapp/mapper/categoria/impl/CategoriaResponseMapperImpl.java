package com.info.infoprimeraapp.mapper.categoria.impl;

import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.mapper.categoria.CategoriaResponseMapper;
import com.info.infoprimeraapp.model.dto.categoria.CategoriaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoriaResponseMapperImpl implements CategoriaResponseMapper {
    @Override
    public CategoriaResponseDTO categoriaToCategoriaResponseDTO(Categoria categoria) {
        return CategoriaResponseDTO.builder()
                .id(categoria.getId().toString())
                .nombre(categoria.getNombre())
                .build();
    }
}
