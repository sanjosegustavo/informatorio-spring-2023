package com.info.infoprimeraapp.mapper.book;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.model.dto.book.BookDTO;

public interface BookMapper {

    public Book bookDTOtoBook(BookDTO bookDTO);

    public BookDTO bookToBookDTO(Book book);
}
