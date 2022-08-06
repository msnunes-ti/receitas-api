package com.example.receitas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome_receita", nullable = false)
    private String nomeReceita;

    @NotNull
    @Column(nullable = false, length = 3000)
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private Double rendimento;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "receita_ingredientes", nullable = false)
    private List<Ingrediente> ingredientes;

    @NotNull
    @Column(name = "is_vegana", nullable = false)
    private Boolean isVegana;
}
