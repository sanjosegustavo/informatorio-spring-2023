package com.info.infoprimeraapp.repository.resena;

import com.info.infoprimeraapp.domain.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, UUID> {
}
