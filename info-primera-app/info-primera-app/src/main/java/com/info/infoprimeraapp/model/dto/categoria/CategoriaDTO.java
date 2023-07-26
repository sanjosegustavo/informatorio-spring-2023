package com.info.infoprimeraapp.model.dto.categoria;

import com.info.infoprimeraapp.model.dto.book.BookDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoriaDTO {
    private String id;
    private String nombre;
    private List<BookDTO> bookDTOS;

}
