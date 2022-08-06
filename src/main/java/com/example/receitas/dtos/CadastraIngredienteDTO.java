package com.example.receitas.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CadastraIngredienteDTO {

    @NotNull
    private String nomeIngrediente;

    @NotNull
    private String quantidadeIngrediente;

}
