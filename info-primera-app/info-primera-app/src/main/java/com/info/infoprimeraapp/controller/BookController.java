package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.book.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController // Anotación a nivel de clase
@RequestMapping("/api/v1/book") // Todos los endpoints comparten esta URI
@Slf4j
public class BookController {

    //IoC Inversión de control
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //GET --> Obtener un recurso
    @GetMapping()
    public List<Book> getAllBooks() {
        log.info("Se esta haciendo una consulta por los libros");
        return bookService.getAllBooks();
    }

    //POST --> Crear un recurso
    @PostMapping()
    public Book createBook(@RequestBody Book book) {
        log.info("Creación de un nuevo libro");
        return bookService.createBook(book);
    }

    @GetMapping("/book_title")
    public Book getBook(@RequestParam(required = true, name = "title") String title) {
        return bookService.getBook(title);
    }

    //PUT --> Actualizar un recurso
    @PutMapping("/{idBook}")
    public String updateBook(@PathVariable(value = "idBook")UUID idBook, @RequestBody Book bookUpdated){
        Optional<Book> book = bookService.updateBook(idBook, bookUpdated);

        if (book.isEmpty()){
            log.info("Libro no encontrado");
            return "Book not found";
        } else {
            log.info("Libro actualizado");
            return "/api/v1/book/" + book.get().getUuid();
        }
    }

    @DeleteMapping("/{idBook}")
    public String deleteBook(@PathVariable(value = "idBook") UUID idBook){
        boolean isBookDeleted = bookService.deleteBook(idBook);
        if (isBookDeleted){
            log.info("Libro eliminado");
            return "Book deleted";
        }
        log.info("Libro no encontrado");
        return "Book not found";
    }
}
