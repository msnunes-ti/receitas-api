package com.example.receitas.services;

import com.example.receitas.dtos.IngredienteDTO;
import com.example.receitas.mappers.IngredienteMapper;
import com.example.receitas.models.Ingrediente;
import com.example.receitas.models.Receita;
import com.example.receitas.repositorys.IngredienteRepository;
import com.example.receitas.repositorys.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;
    private final ReceitaRepository receitaRepository;
    private Receita buscarReceita(Long idDaReceita) {
        return receitaRepository.findById(idDaReceita).orElseThrow(() -> new RuntimeException("Id da Receita não encontrado."));
    }

    public List<IngredienteDTO> buscarIngredientesDaReceita(Long idDaReceita) {
        Receita receita = buscarReceita(idDaReceita);
        List<Ingrediente> ingredienteList = receita.getIngredientes();
        return IngredienteMapper.ingredienteDTOList(ingredienteList);
    }

    

    public void deletarIngredienteDaReceita(Long id) {
        Optional<Ingrediente> ingrediente = Optional.ofNullable(ingredienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Id do Ingrediente não encontrado.")));
        ingredienteRepository.deleteById(ingrediente.get().getId());
    }
}
