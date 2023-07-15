package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.domain.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {

    Author createAuthor(Author author);

    Optional<Author> getAuthor(UUID uuidAuthor);

    Author getAuthor(String nombre, String apellido);

    boolean deleteAutor(UUID uuidAuthor);
}
