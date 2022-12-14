package com.example.receitas.dtos;

import com.example.receitas.models.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class CadastraReceitaDTO {

    @NotNull
    private String nomeReceita;

    @NotNull
    private String descricao;

    @NotNull
    private Double rendimento;

    @Valid
    @NotNull
    private List<Ingrediente> ingredientes;

    @NotNull
    private Boolean isVegana;
}
