package com.example.receitas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IngredienteDTO {

    @NotNull
    private Long id;

    @NotNull
    private String nomeIngrediente;

    @NotNull
    private String quantidadeIngrediente;
}
