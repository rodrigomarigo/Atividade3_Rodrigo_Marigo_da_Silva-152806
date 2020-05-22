package com.example.atividade03_rodrigo_marigo_da_silva_152806.Repository;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    
}