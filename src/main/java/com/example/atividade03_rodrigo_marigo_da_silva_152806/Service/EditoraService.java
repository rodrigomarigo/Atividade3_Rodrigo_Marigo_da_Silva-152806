package com.example.atividade03_rodrigo_marigo_da_silva_152806.Service;

import java.util.List;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Editora;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Repository.EditoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {
    @Autowired
    private EditoraRepository repository;

    public List<Editora> getEditoras(){
        return repository.findAll();
    }

    public void salvar(Editora editora){
        repository.save(editora);
    }

    public Editora getEditoraById(int id){
        return repository.findById(id).get();
    }

    public void remover(Editora editora){
        repository.delete(editora);
    }
}   