package com.info.infoprimeraapp.domain;

import com.info.infoprimeraapp.enumeration.CalificationEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Resena {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(updatable = false, nullable = false, length = 36, columnDefinition = "varchar(36)")
    private UUID id;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = true, nullable = false)
    private String titulo;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = true, nullable = false)
    private String nombreLibro;

    @Column(length = 300, columnDefinition = "varchar(300)", updatable = true, nullable = false)
    private String contenido;

    @Enumerated(EnumType.STRING)
    private CalificationEnum calificacion;

    @Column(updatable = true, nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechaCreacion;
}
