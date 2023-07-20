package com.info.infoprimeraapp.repository.editorial;


import com.info.infoprimeraapp.domain.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, UUID> {
}
