package com.info.infoprimeraapp.service.author.impl;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.repository.author.AuthorRepository;
import com.info.infoprimeraapp.service.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AuthorServiceJPAImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public Author createAuthor(Author author) {
        author.setUuid(UUID.randomUUID());
        authorRepository.save(author);
        return author;
    }

    @Override
    public Optional<Author> getAuthor(UUID uuidAuthor) {
        return authorRepository.findById(uuidAuthor);
    }

    @Override
    public Author getAuthor(String nombre, String apellido) {
        Optional<Author> authorOptional = authorRepository.findAuthorByNombreAndApellidoEqualsIgnoreCase(nombre, apellido);
        if (authorOptional.isPresent()){
            return authorOptional.get();
        }
        return null;
    }

    @Override
    public boolean deleteAutor(UUID uuidAuthor) {
        Optional<Author> authorOptional = authorRepository.findById(uuidAuthor);

        if (authorOptional.isPresent()) {
            authorRepository.delete(authorOptional.get());
            return true;
        }
        return false;
    }


}
