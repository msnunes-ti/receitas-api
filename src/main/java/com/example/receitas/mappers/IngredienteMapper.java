package com.example.receitas.mappers;

import com.example.receitas.dtos.AtualizaIngredienteDTO;
import com.example.receitas.dtos.IngredienteDTO;
import com.example.receitas.models.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public class IngredienteMapper {


    public static IngredienteDTO toIngredienteDTO (Ingrediente ingrediente) {
        IngredienteDTO ingredienteDTO = new IngredienteDTO();
        ingredienteDTO.setId(ingrediente.getId());
        ingredienteDTO.setNomeIngrediente(ingrediente.getNomeIngrediente());
        ingredienteDTO.setQuantidadeIngrediente(ingrediente.getQuantidadeIngrediente());
        return ingredienteDTO;
    }

    public static Ingrediente toIngrediente(AtualizaIngredienteDTO atualizaIngredienteDTO) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(atualizaIngredienteDTO.getId());
        ingrediente.setNomeIngrediente(atualizaIngredienteDTO.getNomeIngrediente());
        ingrediente.setQuantidadeIngrediente(atualizaIngredienteDTO.getQuantidadeIngrediente());
        return ingrediente;
    }

    public static List<IngredienteDTO> ingredienteDTOList(List<Ingrediente> ingredienteList) {
        List<IngredienteDTO> ingredienteDTOList = new ArrayList<>();
        for (Ingrediente i : ingredienteList) {
            ingredienteDTOList.add(IngredienteMapper.toIngredienteDTO(i));
        }
        return ingredienteDTOList;
    }
}
