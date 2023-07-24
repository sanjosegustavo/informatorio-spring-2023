package com.info.infoprimeraapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(updatable = false, nullable = false, length = 36, columnDefinition = "varchar(36)")
    private UUID uuid;

    @Column(length = 40, columnDefinition = "varchar(40)", updatable = true, nullable = false)
    private String nombre;

    @Column(length = 40, columnDefinition = "varchar(40)", updatable = true, nullable = false)
    private String apellido;

    @Column(updatable = true, nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

}
