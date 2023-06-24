package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController // Anotación a nivel de clase
public class BookController {

    //IoC Inversión de control
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //GET --> Obtener un recurso
    @GetMapping("api/v1/book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //POST --> Crear un recurso
    @PostMapping("api/v1/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/api/v1/book_title")
    public String getBook(@RequestParam(required = true, name = "title") String title) {
        return bookService.getBook(title);
    }
}
