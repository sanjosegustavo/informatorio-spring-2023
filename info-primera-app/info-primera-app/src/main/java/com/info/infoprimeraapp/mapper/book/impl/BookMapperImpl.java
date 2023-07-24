package com.info.infoprimeraapp.mapper.book.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.mapper.book.BookMapper;
import com.info.infoprimeraapp.model.dto.book.BookDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public Book bookDTOtoBook(BookDTO bookDTO) {
        return Book.builder()
                .uuid(UUID.randomUUID())
                .isbn(bookDTO.getIsbn())
                .title(bookDTO.getTitle())
                .numberPages(bookDTO.getNumberPages())
                .build();
    }

    @Override
    public BookDTO bookToBookDTO(Book book) {
        return BookDTO.builder()
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .numberPages(book.getNumberPages())
                .idAuthor(book.getAuthor().getUuid().toString())
                .build();
    }
}
