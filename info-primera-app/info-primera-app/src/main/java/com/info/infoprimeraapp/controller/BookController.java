package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.service.book.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createBook(@RequestBody Book book) {
        log.info("Creación de un nuevo libro");
        Book bookCreated = bookService.createBook(book);

        HttpHeaders headers = new HttpHeaders(); // cabecera de la respuesta
        headers.add("Location", "/api/v1/book/" + bookCreated.getUuid());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/book_title")
    public Book getBook(@RequestParam(required = true, name = "title") String title) {
        return bookService.getBook(title);
    }

    //PUT --> Actualizar un recurso
    @PutMapping("/{idBook}")
    public ResponseEntity updateBook(@PathVariable(value = "idBook")UUID idBook, @RequestBody Book bookUpdated)
            throws NotFoundException {
        Optional<Book> book = bookService.updateBook(idBook, bookUpdated);

        if (book.isEmpty()){
            log.info("Libro no encontrado");
            throw new NotFoundException();
        } else {
            log.info("Libro actualizado");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{idBook}")
    public ResponseEntity deleteBook(@PathVariable(value = "idBook") UUID idBook) throws NotFoundException {
        boolean isBookDeleted = bookService.deleteBook(idBook);
        if (isBookDeleted){
            log.info("Libro eliminado");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        log.info("Libro no encontrado");
        throw new NotFoundException();
    }

    // Por variable --> Información en URL
    // Por parámetro --> Parámetro en la request
    @GetMapping("/{idBook}")
    public Book getBookById(@PathVariable(value = "idBook") UUID idBook) throws NotFoundException {
        return bookService.getBookById(idBook).orElseThrow(NotFoundException::new);
    }
}
