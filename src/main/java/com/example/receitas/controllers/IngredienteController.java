package com.example.receitas.controllers;

import com.example.receitas.dtos.IngredienteDTO;
import com.example.receitas.services.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredientes")
@RequiredArgsConstructor
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @GetMapping(path = "/{idReceita}")
    public List<IngredienteDTO> buscarTodosIngredientes(@PathVariable Long idReceita) {
        return ingredienteService.buscarIngredientesDaReceita(idReceita);
    }

    @DeleteMapping(path = "/{idReceita}")
    public void deletaIngredientesPorIds(@PathVariable Long idReceita, @RequestBody Long... idsIngredientes) {
        ingredienteService.deletarIngredienteDaReceita(idReceita, idsIngredientes);
    }
}
