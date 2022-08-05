package com.example.receitas.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredienteDTO {

    private Long id;

    private String nomeIngrediente;

    private String quantidadeIngrediente;
}
