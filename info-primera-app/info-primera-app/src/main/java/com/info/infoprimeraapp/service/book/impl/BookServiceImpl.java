package com.info.infoprimeraapp.service.book.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.book.BookService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    Map<UUID, Book> bookMap;

    public BookServiceImpl() {
        bookMap = new HashMap<>();

        Book book = new Book();
        book.setUuid(UUID.randomUUID());
        book.setAuthor("Julio Cortazar");
        book.setTitle("Rayuela");

        Book book1 = new Book();
        book1.setUuid(UUID.randomUUID());
        book1.setAuthor("Gabriel García Marquez");
        book1.setTitle("Cien años de soledad");

        Book book2 = new Book();
        book2.setUuid(UUID.randomUUID());
        book2.setAuthor("Alejandro Dolina");
        book2.setTitle("Cartas marcadas");

        bookMap.put(book.getUuid(), book);
        bookMap.put(book1.getUuid(), book1);
        bookMap.put(book2.getUuid(), book2);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public Book createBook(Book book) {
        book.setUuid(UUID.randomUUID());
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
    public Optional<Book> updateBook(UUID uuidBook, Book bookUpdated) {
        Book book = bookMap.get(uuidBook);

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
    public Optional<Book> getBookById(UUID uuidBook) {
        return Optional.of(bookMap.get(uuidBook));
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
        for (Book book : bookMap.values()) {
            if(book.getTitle().equalsIgnoreCase(title)){
                bookMap.values().remove(book);
                return true;
            }
        }
        return false;
    }
}
