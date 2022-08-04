package com.example.receitas.dtos;

import com.example.receitas.models.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class AtualizaReceitaDTO {

    @NotNull
    private String nomeReceita;

    @NotNull
    private String descricao;

    @NotNull
    private String rendimento;

    @NotNull
    private List<Ingrediente> ingredientes;

    @NotNull
    private Boolean isVegana;
}
