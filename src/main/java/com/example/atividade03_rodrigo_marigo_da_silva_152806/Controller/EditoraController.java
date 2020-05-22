package com.example.atividade03_rodrigo_marigo_da_silva_152806.Controller;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Editora;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.AutorService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.EditoraService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping("/editoras")
    public ModelAndView getEditoras() {
        ModelAndView mv = new ModelAndView("editorasTemplate");
        
        mv.addObject("editora", new Editora());
        mv.addObject("editoras", editoraService.getEditoras());

        return mv;
    }
    
    @PostMapping("/salvarEditora")
    public String salvar(@ModelAttribute Editora editora){
        editoraService.salvar(editora);

        return "redirect:/editoras";
    }
    
}