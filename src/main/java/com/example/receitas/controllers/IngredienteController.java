package com.example.receitas.controllers;

import com.example.receitas.dtos.IngredienteDTO;
import com.example.receitas.models.Ingrediente;
import com.example.receitas.services.IngredienteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredientes")
@RequiredArgsConstructor
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @GetMapping
    public List<IngredienteDTO> buscarTodosIngredientes(@RequestParam(required = false) Long numeroDaReceita) {
        return ingredienteService.buscartodos(numeroDaReceita);
    }


}
