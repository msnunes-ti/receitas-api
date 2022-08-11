package com.example.receitas.services;

import com.example.receitas.dtos.AtualizaIngredienteDTO;
import com.example.receitas.dtos.CadastraIngredienteDTO;
import com.example.receitas.dtos.IngredienteDTO;
import com.example.receitas.mappers.IngredienteMapper;
import com.example.receitas.models.Ingrediente;
import com.example.receitas.models.Receita;
import com.example.receitas.repositorys.IngredienteRepository;
import com.example.receitas.repositorys.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void cadastrarIngrediente(Long idReceita, CadastraIngredienteDTO cadastraIngredienteDTO) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNomeIngrediente(cadastraIngredienteDTO.getNomeIngrediente());
        ingrediente.setQuantidadeIngrediente(cadastraIngredienteDTO.getQuantidadeIngrediente());
        Receita receita = receitaRepository.getReferenceById(idReceita);
        receita.getIngredientes().add(ingrediente);
        receitaRepository.save(receita);
    }

    @Transactional
    public void atualizaIngrediente(AtualizaIngredienteDTO atualizaIngredienteDTO) {
        Ingrediente adicionarIngrediente = IngredienteMapper.toIngrediente(atualizaIngredienteDTO);
        ingredienteRepository.save(adicionarIngrediente);
    }

    @Transactional
    public void deletarIngredienteDaReceita(Long id) {
        Optional<Ingrediente> ingrediente = Optional.ofNullable(ingredienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Id do Ingrediente não encontrado.")));
        if (ingrediente.isEmpty()) {
            throw new RuntimeException("Ingrediente não encontrado");
        }
        ingredienteRepository.deleteById(ingrediente.get().getId());
    }
}
