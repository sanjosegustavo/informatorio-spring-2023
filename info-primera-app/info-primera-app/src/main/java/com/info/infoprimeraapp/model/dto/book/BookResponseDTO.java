package com.info.infoprimeraapp.model.dto.book;

import com.info.infoprimeraapp.model.dto.categoria.CategoriaResponseDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookResponseDTO {
    private String title;
    private String isbn;
    private int numberPages;
    private String nombreAuthor;
    private List<CategoriaResponseDTO> categoriaResponseDTOS;
}
