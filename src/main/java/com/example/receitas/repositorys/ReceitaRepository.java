package com.example.receitas.repositorys;

import com.example.receitas.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByNomeReceita(String nome);

    Optional<Receita> findById (Long id);
}
