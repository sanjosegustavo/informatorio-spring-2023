package com.info.infoprimeraapp.repository.categoria.impl;

import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.repository.categoria.CategoriaRepository;
import com.info.infoprimeraapp.service.categoria.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CategoriaServiceJpaImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(UUID id) {
        return Optional.of(categoriaRepository.findById(id)).orElse(null);
    }
}
