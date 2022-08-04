package com.example.receitas.services;

import com.example.receitas.dtos.CadastraReceitaDTO;
import com.example.receitas.dtos.ReceitaDTO;
import com.example.receitas.mappers.ReceitaMapper;
import com.example.receitas.models.Receita;
import com.example.receitas.repositorys.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    private Receita buscarPorId(Long id) {
        return receitaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public ReceitaDTO buscarTodosPorId (Long id) {
        return ReceitaMapper.toReceitaDTO(buscarPorId(id));
    }

    public List<ReceitaDTO> buscarTodos(String nome) {
        if (nome == null) {
            return ReceitaMapper.receitaDTOList(receitaRepository.findAll());
        }
        return ReceitaMapper.receitaDTOList(receitaRepository.findByNomeReceitaList(nome));
    }

    public void cadastraReceita(CadastraReceitaDTO cadastraReceitaDTO) {
        receitaRepository.save(ReceitaMapper.toReceita(cadastraReceitaDTO));
    }


}
