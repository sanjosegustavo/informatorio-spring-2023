package com.info.infoprimeraapp.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResenaCsvRecord {

    @CsvBindByName(column = "titulo")
    private String titulo;

    @CsvBindByName(column = "nombreLibro")
    private String nombreLibro;

    @CsvBindByName(column = "contenido")
    private String contenido;

    @CsvBindByName(column = "calificacion")
    private String calificacion;

    @CsvBindByName(column = "fechaCreacion")
    private String fechaCreacion;

}
