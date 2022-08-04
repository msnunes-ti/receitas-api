package com.example.receitas.dtos;

import com.example.receitas.models.Ingrediente;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ReceitaDTO {

        private Long id;

        @NotNull
        private String nomeReceita;

        @NotNull
        private String descricao;

        @NotNull
        private Double rendimento;

        @NotNull
        private List<Ingrediente> ingredientes;

        @NotNull
        private boolean isVegana;
}
