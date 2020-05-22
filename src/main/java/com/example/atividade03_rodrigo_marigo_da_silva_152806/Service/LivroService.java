package com.example.atividade03_rodrigo_marigo_da_silva_152806.Service;

import java.util.List;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Livro;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public List<Livro> getLivros(){
        return repository.findAll();
    }

    public void salvar(Livro livro){
        repository.save(livro);
    }
    
    public Livro getLivroById(int id){
        return repository.findById(id).get();
    }

    public void remover(Livro livro){
        repository.delete(livro);
    }
}