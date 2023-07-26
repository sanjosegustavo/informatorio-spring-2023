package com.info.infoprimeraapp.mapper.book.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.domain.Categoria;
import com.info.infoprimeraapp.mapper.book.BookResponseMapper;
import com.info.infoprimeraapp.mapper.categoria.CategoriaResponseMapper;
import com.info.infoprimeraapp.model.dto.book.BookResponseDTO;
import com.info.infoprimeraapp.model.dto.categoria.CategoriaResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BookResponseMapperImpl implements BookResponseMapper {

    private final CategoriaResponseMapper categoriaResponseMapper;

    @Override
    public BookResponseDTO bookToBookResponseDTO(Book book) {
        BookResponseDTO bookResponseDTO = BookResponseDTO.builder()
                .nombreAuthor(book.getAuthor().getNombre())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .numberPages(book.getNumberPages())
                .build();

        List<CategoriaResponseDTO> categoriaResponseDTOList = new ArrayList<>();
        for (Categoria categoria : book.getCategorias()) {
            categoriaResponseDTOList.add(categoriaResponseMapper.categoriaToCategoriaResponseDTO(categoria));
        }

        bookResponseDTO.setCategoriaResponseDTOS(categoriaResponseDTOList);

        return bookResponseDTO;
    }
}
