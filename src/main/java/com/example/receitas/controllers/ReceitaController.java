package com.example.receitas.controllers;

import com.example.receitas.dtos.CadastraReceitaDTO;
import com.example.receitas.dtos.ReceitaDTO;
import com.example.receitas.services.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;

    @GetMapping(path = "/{id}")
    public ReceitaDTO buscarPorId(@PathVariable Long id) {
        return receitaService.buscarTodosPorId(id);
    }

    @GetMapping
    public List<ReceitaDTO> buscarTodos(@RequestParam(required = false) @Valid String nome) {
        return receitaService.buscarTodos(nome);
    }

    @PostMapping
    public void cadastraReceita(CadastraReceitaDTO cadastraReceitaDTO) {
        receitaService.cadastraReceita(cadastraReceitaDTO);
    }
}
