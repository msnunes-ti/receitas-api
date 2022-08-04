package com.example.receitas.controllers;

import com.example.receitas.dtos.ReceitaDTO;
import com.example.receitas.services.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;

    @RequestMapping(path = "/{id}")
    public List<ReceitaDTO> buscarTodos(@PathVariable Long id) {
        return receitaService.buscarTodos(id);
    }

}
