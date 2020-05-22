package com.example.atividade03_rodrigo_marigo_da_silva_152806.Repository;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    
}