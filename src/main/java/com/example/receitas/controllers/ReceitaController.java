package com.example.receitas.controllers;

import com.example.receitas.services.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;



}
