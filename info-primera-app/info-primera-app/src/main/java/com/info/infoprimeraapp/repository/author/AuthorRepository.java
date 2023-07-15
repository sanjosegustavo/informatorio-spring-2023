package com.info.infoprimeraapp.repository.author;

import com.info.infoprimeraapp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    Optional<Author> findAuthorByNombreAndApellidoEqualsIgnoreCase(String nombre, String apellido);

}
