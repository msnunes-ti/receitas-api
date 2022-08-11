package com.example.receitas.controllers;

import com.example.receitas.dtos.AtualizaIngredienteDTO;
import com.example.receitas.dtos.CadastraIngredienteDTO;
import com.example.receitas.dtos.IngredienteDTO;
import com.example.receitas.services.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @PostMapping(path = "/{idReceita}")
    public void adicionarIngrediente(@PathVariable Long idReceita, @RequestBody CadastraIngredienteDTO cadastraIngredienteDTO) {
        ingredienteService.cadastrarIngrediente(idReceita, cadastraIngredienteDTO);
    }

    @PutMapping
    public void atualizaIngrediente(@RequestBody AtualizaIngredienteDTO atualizaIngredienteDTO) {
        ingredienteService.atualizaIngrediente(atualizaIngredienteDTO);
    }

    @Transactional
    @DeleteMapping(path = "/{id}")
    public void deletaIngredientesPorIds(@PathVariable Long id) {
        ingredienteService.deletarIngredienteDaReceita(id);
    }
}
