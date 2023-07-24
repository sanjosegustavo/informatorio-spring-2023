package com.info.infoprimeraapp.service.book;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.model.dto.book.BookDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<BookDTO> getAllBooks();

    Book createBook(BookDTO book) throws NotFoundException;

    Book getBook(String title);

    Optional<Book> updateBook(UUID uuidBook, BookDTO bookDTOUpdated);

    boolean deleteBook(UUID uuidBook);

    Optional<BookDTO> getBookById(UUID uuidBook);

}
