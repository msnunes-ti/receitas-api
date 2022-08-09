package com.example.receitas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AtualizaIngredienteDTO {

    @NotNull
    private Long id;

    @NotNull
    private String nomeIngrediente;

    @NotNull
    private String quantidadeIngrediente;

}
