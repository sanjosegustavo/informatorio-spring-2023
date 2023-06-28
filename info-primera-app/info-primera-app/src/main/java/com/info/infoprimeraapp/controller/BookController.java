package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public Book getBook(@RequestParam(required = true, name = "title") String title) {
        return bookService.getBook(title);
    }

    //PUT --> Actualizar un recurso
    @PutMapping("/api/v1/book/{idBook}")
    public String updateBook(@PathVariable(value = "idBook")UUID idBook, @RequestBody Book bookUpdated){
        Optional<Book> book = bookService.updateBook(idBook, bookUpdated);

        if (book.isEmpty()){
            return "Book not found";
        } else {
            return "/api/v1/book/" + book.get().getUuid();
        }
    }

    @DeleteMapping("/api/v1/book/{idBook}")
    public String deleteBook(@PathVariable(value = "idBook") UUID idBook){
        return bookService.deleteBook(idBook);
    }
}
