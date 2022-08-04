package com.example.receitas.controllers;

import com.example.receitas.dtos.AtualizaReceitaDTO;
import com.example.receitas.dtos.CadastraReceitaDTO;
import com.example.receitas.dtos.ReceitaDTO;
import com.example.receitas.services.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(name = "/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;

    @GetMapping(path = "/{id}")
    public ReceitaDTO buscarPorId(@PathVariable Long id) {
        return receitaService.buscaReceitaPorId(id);
    }

    @GetMapping
    public List<ReceitaDTO> buscarTodos(@RequestParam(required = false) String nome) {
        return receitaService.buscarTodos(nome);
    }

    @PostMapping
    public void cadastraReceita(@RequestBody @Valid @NotNull CadastraReceitaDTO cadastraReceitaDTO) {
        receitaService.cadastraReceita(cadastraReceitaDTO);
    }

    @PutMapping(path = "/{id}")
    public void atualizaReceita(@PathVariable Long id, @RequestBody @Valid @NotNull AtualizaReceitaDTO atualizaReceitaDTO) {
        receitaService.atualizaReceita(id, atualizaReceitaDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deletaReceitaPorId(@PathVariable Long id) {
        receitaService.deletaReceita(id);
    }
}
