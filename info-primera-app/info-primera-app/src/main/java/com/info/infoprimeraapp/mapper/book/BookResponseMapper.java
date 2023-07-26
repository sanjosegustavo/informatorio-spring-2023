package com.info.infoprimeraapp.mapper.book;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.model.dto.book.BookResponseDTO;

public interface BookResponseMapper {

    BookResponseDTO bookToBookResponseDTO(Book book);
}
