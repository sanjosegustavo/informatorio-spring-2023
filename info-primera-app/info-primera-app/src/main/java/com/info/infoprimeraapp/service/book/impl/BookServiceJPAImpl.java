package com.info.infoprimeraapp.service.book.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.repository.book.BookRepository;
import com.info.infoprimeraapp.service.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class BookServiceJPAImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // Traer todos los libros
    }

    @Override
    public Book createBook(Book book) {
        book.setUuid(UUID.randomUUID());
        return bookRepository.save(book); // Guardar en la base de datos
    }

    @Override
    public Book getBook(String title) {
        Optional<Book> bookOptional = bookRepository.findBookByTitleEqualsIgnoreCase(title);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }
        return null;
    }

    @Override
    public Optional<Book> updateBook(UUID uuidBook, Book bookUpdated) {
        // Buscar libro por ID
        Optional<Book> bookOptional = bookRepository.findById(uuidBook);

        if(bookOptional.isPresent()){
            updatingBook(bookOptional.get(), bookUpdated);
            //Save --> Si existe entonces lo actualiza  y si no lo crea
            return Optional.of(bookRepository.save(bookOptional.get()));

        }else{
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteBook(UUID uuidBook) {
        if (bookRepository.findById(uuidBook).isPresent()) {
            bookRepository.deleteById(uuidBook);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Book> getBookById(UUID uuidBook) {
        return Optional.of(bookRepository.findById(uuidBook)).orElse(null);
    }

    private void updatingBook(Book book, Book bookUpdated){
        if (bookUpdated.getTitle() != null){
            book.setTitle(bookUpdated.getTitle());
        }

        if (bookUpdated.getAuthor() != null){
            book.setAuthor(bookUpdated.getAuthor());
        }
    }


    private boolean deleteBookByName(String title){
        Optional<Book> bookOptional = bookRepository.findBookByTitleEqualsIgnoreCase(title);

        if (bookOptional.isPresent()){
            bookRepository.delete(bookOptional.get());
            return true;
        }
        return false;
    }


}
