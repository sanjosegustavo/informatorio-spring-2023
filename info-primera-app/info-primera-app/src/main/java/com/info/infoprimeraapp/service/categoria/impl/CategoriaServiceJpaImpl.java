package com.info.infoprimeraapp.service.categoria.impl;

import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.mapper.categoria.CategoriaMapper;
import com.info.infoprimeraapp.model.dto.categoria.CategoriaDTO;
import com.info.infoprimeraapp.repository.categoria.CategoriaRepository;
import com.info.infoprimeraapp.service.categoria.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CategoriaServiceJpaImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> getAllCategorias() {
        List<CategoriaDTO> categoriaDTOS = new ArrayList<>();

        for (Categoria categoria : categoriaRepository.findAll()) {
            categoriaDTOS.add(categoriaMapper.categoriaToCategoriaDTO(categoria));
        }

        return categoriaDTOS;
    }

    @Override
    public Optional<CategoriaDTO> getCategoriaById(UUID id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isPresent()) {
            return Optional.of(categoriaMapper.categoriaToCategoriaDTO(categoriaOptional.get()));
        }

        return Optional.empty();
    }
}
