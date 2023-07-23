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

public class EditorialCsvRecord {

    @CsvBindByName(column = "nombre")
    private String nombre;

    @CsvBindByName(column = "direccion")
    private String direccion;

    @CsvBindByName(column = "ciudad")
    private String ciudad;

    @CsvBindByName(column = "pais")
    private String pais;

    @CsvBindByName(column = "telefono")
    private String telefono;

    @CsvBindByName(column = "sitioWeb")
    private String sitioWeb;
}
