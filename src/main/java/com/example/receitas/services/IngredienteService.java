package com.example.receitas.services;

import com.example.receitas.repositorys.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredienteService {

    IngredienteRepository ingredienteRepository;
}
