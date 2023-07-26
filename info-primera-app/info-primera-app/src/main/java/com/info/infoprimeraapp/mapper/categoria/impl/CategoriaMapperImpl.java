package com.info.infoprimeraapp.mapper.categoria.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.mapper.book.BookMapper;
import com.info.infoprimeraapp.mapper.categoria.CategoriaMapper;
import com.info.infoprimeraapp.model.dto.book.BookDTO;
import com.info.infoprimeraapp.model.dto.categoria.CategoriaDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CategoriaMapperImpl implements CategoriaMapper {

    private final BookMapper bookMapper;

    @Override
    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = CategoriaDTO.builder()
                .id(categoria.getId().toString())
                .nombre(categoria.getNombre())
                .build();

        if (!categoria.getBooks().isEmpty()) {
            List<BookDTO> bookDTOList = new ArrayList<>();

            for (Book book : categoria.getBooks()) {
                bookDTOList.add(bookMapper.bookToBookDTO(book));
            }
            categoriaDTO.setBookDTOS(bookDTOList);
        }

        return categoriaDTO;
    }


}
