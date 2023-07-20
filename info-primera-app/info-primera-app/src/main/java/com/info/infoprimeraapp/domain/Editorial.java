package com.info.infoprimeraapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Editorial {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(updatable = false, nullable = false, length = 36, columnDefinition = "varchar(36)")
    private UUID id;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = true, nullable = false)
    private String nombre;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = true, nullable = false)
    private String direccion;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = true, nullable = false)
    private String ciudad;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = true, nullable = false)
    private String pais;

    @Column(length = 20, columnDefinition = "varchar(20)", updatable = true, nullable = false)
    private String telefono;

    @Column(length = 100, columnDefinition = "varchar(100)", updatable = true, nullable = false)
    private String sitioWeb;

}
