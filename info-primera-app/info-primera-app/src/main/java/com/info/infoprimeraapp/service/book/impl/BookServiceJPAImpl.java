package com.info.infoprimeraapp.service.book.impl;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.mapper.book.BookMapper;
import com.info.infoprimeraapp.model.dto.book.BookDTO;
import com.info.infoprimeraapp.repository.author.AuthorRepository;
import com.info.infoprimeraapp.repository.book.BookRepository;
import com.info.infoprimeraapp.service.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service
@AllArgsConstructor
public class BookServiceJPAImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;


    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll(); // Traer todos los libros
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : bookList) {
            bookDTOList.add(bookMapper.bookToBookDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public Book createBook(BookDTO bookDTO) throws NotFoundException {
        Book book = bookMapper.bookDTOtoBook(bookDTO);
        Optional<Author> optionalAuthor = authorRepository.findById(UUID.fromString(bookDTO.getIdAuthor()));

        if (optionalAuthor.isPresent()) {
            book.setAuthor(optionalAuthor.get());
            return bookRepository.save(book);// Guardar en la base de datos
        }
        throw new NotFoundException();
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
    public Optional<Book> updateBook(UUID uuidBook, BookDTO bookDTOUpdated) {
        // Buscar libro por ID
        Optional<Book> bookOptional = bookRepository.findById(uuidBook);

        if(bookOptional.isPresent()){
            updatingBook(bookOptional.get(), bookDTOUpdated);
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
    public Optional<BookDTO> getBookById(UUID uuidBook) {
        Optional<Book> bookOptional = bookRepository.findById(uuidBook);

        if (bookOptional.isPresent()) {
            return Optional.of(bookMapper.bookToBookDTO(bookOptional.get()));
        }
        return Optional.empty();
    }

    private void updatingBook(Book book, BookDTO bookDTOUpdated){
        Optional<Author> optionalAuthor = authorRepository.findById(UUID.fromString(bookDTOUpdated.getIdAuthor()));

        if (bookDTOUpdated.getTitle() != null){
            book.setTitle(bookDTOUpdated.getTitle());
        }

        if (optionalAuthor.isPresent()){
            book.setAuthor(optionalAuthor.get());
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
