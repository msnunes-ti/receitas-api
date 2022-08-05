package com.example.receitas.services;

import com.example.receitas.models.Ingrediente;
import com.example.receitas.repositorys.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredienteService {

    IngredienteRepository ingredienteRepository;

    public List<Ingrediente> buscartodos() {
        return ingredienteRepository.findAll();
    }
}
