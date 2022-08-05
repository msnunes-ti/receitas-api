package com.example.receitas.services;

import com.example.receitas.dtos.IngredienteDTO;
import com.example.receitas.dtos.ReceitaDTO;
import com.example.receitas.mappers.IngredienteMapper;
import com.example.receitas.models.Ingrediente;
import com.example.receitas.models.Receita;
import com.example.receitas.repositorys.IngredienteRepository;
import com.example.receitas.repositorys.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredienteService {

    IngredienteRepository ingredienteRepository;
    ReceitaRepository receitaRepository;

    public List<IngredienteDTO> buscartodos(Long numeroDaReceita) {
        List<IngredienteDTO> ingredienteDTOList = new ArrayList<>();
        
        return null;
    }
}
