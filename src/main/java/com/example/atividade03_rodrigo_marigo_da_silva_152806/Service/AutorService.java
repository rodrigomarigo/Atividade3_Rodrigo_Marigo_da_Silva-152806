package com.example.atividade03_rodrigo_marigo_da_silva_152806.Service;

import java.util.List;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Autor;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    public List<Autor> getAutores(){
        return repository.findAll();
    }

    public void salvar(Autor autor){
        repository.save(autor);
    }

    public Autor getAutorById(int id){
        return repository.findById(id).get();
    }
}