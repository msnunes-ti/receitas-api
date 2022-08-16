package com.example.receitas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome_ingrediente", nullable = false)
    private String nomeIngrediente;

    @NotNull
    @Column(name = "qtde_ingrediente", nullable = false)
    private String quantidadeIngrediente;
    
}
