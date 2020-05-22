package com.example.atividade03_rodrigo_marigo_da_silva_152806.Controller;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.AutorService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.EditoraService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;

public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;
    
}