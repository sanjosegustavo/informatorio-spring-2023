package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Book;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book createBook(Book book);

    Book getBook(String title);

}
