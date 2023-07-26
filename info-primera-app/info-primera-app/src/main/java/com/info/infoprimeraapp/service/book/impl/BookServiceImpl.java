package com.info.infoprimeraapp.service.book.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.mapper.book.BookMapper;
import com.info.infoprimeraapp.mapper.book.BookResponseMapper;
import com.info.infoprimeraapp.model.dto.book.BookDTO;
import com.info.infoprimeraapp.model.dto.book.BookResponseDTO;
import com.info.infoprimeraapp.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    Map<UUID, Book> bookMap;

    private final BookMapper bookMapper;
    private final BookResponseMapper bookResponseMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, BookResponseMapper bookResponseMapper) {
        this.bookMapper = bookMapper;
        this.bookResponseMapper = bookResponseMapper;
        bookMap = new HashMap<>();

        Book book = new Book();
        book.setUuid(UUID.randomUUID());
        //book.setAuthor("Julio Cortazar");
        book.setTitle("Rayuela");

        Book book1 = new Book();
        book1.setUuid(UUID.randomUUID());
        //book1.setAuthor("Gabriel García Marquez");
        book1.setTitle("Cien años de soledad");

        Book book2 = new Book();
        book2.setUuid(UUID.randomUUID());
        //book2.setAuthor("Alejandro Dolina");
        book2.setTitle("Cartas marcadas");

        bookMap.put(book.getUuid(), book);
        bookMap.put(book1.getUuid(), book1);
        bookMap.put(book2.getUuid(), book2);
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
        for (Book book : bookMap.values()) {
            bookResponseDTOList.add(bookResponseMapper.bookToBookResponseDTO(book));
        }
        return bookResponseDTOList;
    }

    @Override
    public Book createBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOtoBook(bookDTO);
        //Queda pendiente agregar autores.
        bookMap.put(book.getUuid(), book);
        return book;
    }

    @Override
    public Book getBook(String title) {
        //realizado como tarea
        Book book = new Book();
        for (Map.Entry<UUID, Book> entry : bookMap.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                book = entry.getValue();
                break;
            }
        }
        return book;
    }

    @Override
    public Optional<Book> updateBook(UUID uuidBook, BookDTO bookDTOUpdated) {
        Book book = bookMap.get(uuidBook);
        Book bookUpdated = bookMapper.bookDTOtoBook(bookDTOUpdated);

        if(book != null){
            updatingBook(book, bookUpdated);
            return Optional.of(book);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteBook(UUID uuidBook) {
        Book book = bookMap.get(uuidBook);

        if(book != null){
            bookMap.remove(uuidBook);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Optional<BookDTO> getBookById(UUID uuidBook) {
        return Optional.of(bookMapper.bookToBookDTO(bookMap.get(uuidBook)));
    }

    private void updatingBook(Book book, Book bookUpdated){

        if (bookUpdated.getTitle() != null){
            book.setTitle(bookUpdated.getTitle());
        }

        /*
        if (bookDTOUpdated.getIdAuthor() .getAuthor() != null){
            book.setAuthor(bookUpdated.getAuthor());
        }*/
    }

    private boolean deleteBookByName(String title){
        for (Book book : bookMap.values()) {
            if(book.getTitle().equalsIgnoreCase(title)){
                bookMap.values().remove(book);
                return true;
            }
        }
        return false;
    }
}
