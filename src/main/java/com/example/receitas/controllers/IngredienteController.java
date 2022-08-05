package com.example.receitas.controllers;

import com.example.receitas.models.Ingrediente;
import com.example.receitas.services.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredientes")
@RequiredArgsConstructor
public class IngredienteController {

    private final IngredienteService ingredienteService;

    public List<Ingrediente> buscarTodosIngredientes() {
        return ingredienteService.buscartodos();
    }


}
