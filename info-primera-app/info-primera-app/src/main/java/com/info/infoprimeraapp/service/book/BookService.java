package com.info.infoprimeraapp.service.book;

import com.info.infoprimeraapp.domain.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<Book> getAllBooks();

    Book createBook(Book book);

    Book getBook(String title);

    Optional<Book> updateBook(UUID uuidBook, Book bookUpdated);

    boolean deleteBook(UUID uuidBook);

    Optional<Book> getBookById(UUID uuidBook);

}
