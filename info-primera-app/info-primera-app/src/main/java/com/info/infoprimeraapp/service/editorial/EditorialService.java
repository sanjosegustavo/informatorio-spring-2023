package com.info.infoprimeraapp.service.editorial;

import com.info.infoprimeraapp.domain.Editorial;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EditorialService {
    List<Editorial> getAllEditorial();

    Editorial createEditorial(Editorial editorial);

    Editorial getEditorial(String title);

    Optional<Editorial> updateEditorial(UUID uuidEditorial, Editorial editorialUpdated);

    boolean deleteEditorial(UUID uuidEditorial);

    Optional<Editorial> getEditorialById(UUID uuidEditorial);

}
