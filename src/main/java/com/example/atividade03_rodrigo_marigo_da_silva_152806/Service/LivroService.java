package com.example.atividade03_rodrigo_marigo_da_silva_152806.Service;

import java.util.List;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Livro;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Repository.LivroRepository;

import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private LivroRepository repository;

    public List<Livro> getLivros(){
        return repository.findAll();
    }

    public void salvar(Livro livro){
        repository.save(livro);
    }
    
}