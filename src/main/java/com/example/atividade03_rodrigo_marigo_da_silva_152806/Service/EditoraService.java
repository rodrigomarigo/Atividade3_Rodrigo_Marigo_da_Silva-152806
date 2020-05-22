package com.example.atividade03_rodrigo_marigo_da_silva_152806.Service;

import java.util.List;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Editora;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Repository.EditoraRepository;

public class EditoraService {
    private EditoraRepository repository;

    public List<Editora> getEditoras(){
        return repository.findAll();
    }

    public void salvar(Editora editora){
        repository.save(editora);
    }
}   