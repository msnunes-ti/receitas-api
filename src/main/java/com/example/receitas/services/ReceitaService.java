package com.example.receitas.services;

import com.example.receitas.dtos.ReceitaDTO;
import com.example.receitas.models.Receita;
import com.example.receitas.repositorys.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    private final Receita buscarPorId(Long id) {
        return receitaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public List<ReceitaDTO> buscarTodos(Long id) {
        if (id == null) {
            receitaRepository.findAll();
        }
        return buscarPorId(id);
    }
}
