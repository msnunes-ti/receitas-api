package com.example.receitas.mappers;

import com.example.receitas.dtos.AtualizaReceitaDTO;
import com.example.receitas.dtos.CadastraReceitaDTO;
import com.example.receitas.dtos.ReceitaDTO;
import com.example.receitas.models.Receita;

import java.util.ArrayList;
import java.util.List;

public class ReceitaMapper {

    public static ReceitaDTO toReceitaDTO(Receita receita) {
        ReceitaDTO receitaDTO = new ReceitaDTO();
        receitaDTO.setId(receita.getId());
        receitaDTO.setNomeReceita(receita.getNomeReceita());
        receitaDTO.setDescricao(receita.getDescricao());
        receitaDTO.setIngredientes(receita.getIngredientes());
        receitaDTO.setRendimento(receita.getRendimento());
        receitaDTO.setVegana(receita.getIsVegana());
        return receitaDTO;
    }

    public static Receita toReceita(CadastraReceitaDTO cadastrareceitaDTO){
        Receita receita = new Receita();
        receita.setNomeReceita(cadastrareceitaDTO.getNomeReceita());
        receita.setDescricao(cadastrareceitaDTO.getDescricao());
        receita.setIngredientes(cadastrareceitaDTO.getIngredientes());
        receita.setRendimento(cadastrareceitaDTO.getRendimento());
        receita.setIsVegana(cadastrareceitaDTO.getIsVegana());
        return receita;
    }

    public static Receita toReceitaAtualiza(AtualizaReceitaDTO atualizaReceitaDTO) {
        Receita receita = new Receita();
        receita.setNomeReceita(atualizaReceitaDTO.getNomeReceita());
        receita.setDescricao(atualizaReceitaDTO.getDescricao());
        receita.setIngredientes(atualizaReceitaDTO.getIngredientes());
        receita.setRendimento(atualizaReceitaDTO.getRendimento());
        receita.setIsVegana(atualizaReceitaDTO.getIsVegana());
        return receita;
    }

    public static List<ReceitaDTO> receitaDTOList (List<Receita> receitaList) {
        List<ReceitaDTO> receitaDTOList = new ArrayList<>();
        for (Receita r : receitaList) {
            receitaDTOList.add(ReceitaMapper.toReceitaDTO(r));
        }
        return receitaDTOList;
    }

}
