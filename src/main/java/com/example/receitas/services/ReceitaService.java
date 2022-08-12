package com.example.receitas.services;

import com.example.receitas.dtos.AtualizaReceitaDTO;
import com.example.receitas.dtos.CadastraReceitaDTO;
import com.example.receitas.dtos.ReceitaDTO;
import com.example.receitas.mappers.ReceitaMapper;
import com.example.receitas.models.Receita;
import com.example.receitas.repositorys.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    @Scheduled
    public Receita buscaPorId(Long id) {
        return receitaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    public ReceitaDTO buscaReceitaPorId(Long id) {
        return ReceitaMapper.toReceitaDTO(buscaPorId(id));
    }

    public List<ReceitaDTO> buscarTodos(String descricao, Boolean isVegana, Double rendimento) {
        if (descricao == null || isVegana == null || rendimento == null) {
            return ReceitaMapper.receitaDTOList(receitaRepository.findAll());
        }
        return ReceitaMapper.receitaDTOList(receitaRepository.findByisVeganaAndDescricaoContainsAndRendimento(isVegana, descricao, rendimento));
    }

    @Transactional
    public void cadastraReceita(CadastraReceitaDTO cadastraReceitaDTO) {
        receitaRepository.save(ReceitaMapper.toReceita(cadastraReceitaDTO));
    }

    @Transactional
    public void atualizaReceita(Long id, AtualizaReceitaDTO atualizaReceitaDTO) {
        Receita receitaEncontrada = buscaPorId(id);
        Receita receitaAtualizar = ReceitaMapper.toReceitaAtualiza(atualizaReceitaDTO);
        receitaAtualizar.setId(receitaEncontrada.getId());
        receitaRepository.save(receitaAtualizar);
    }

    @Transactional
    public void deletaReceita (Long id) {
        Receita receita = buscaPorId(id);
        receitaRepository.delete(receita);
    }
}
