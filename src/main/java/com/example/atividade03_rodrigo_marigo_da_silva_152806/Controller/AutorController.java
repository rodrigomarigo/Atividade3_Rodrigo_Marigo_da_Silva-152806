package com.example.atividade03_rodrigo_marigo_da_silva_152806.Controller;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Autor;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.AutorService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.EditoraService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/autores")
    public ModelAndView getAutores() {
        ModelAndView mv = new ModelAndView("autoresTemplate");
        
        mv.addObject("autor", new Autor());
        mv.addObject("autores", autorService.getAutores());

        return mv;
    }
    
    @PostMapping("/salvarAutor")
    public String salvar(@ModelAttribute Autor autor){
        autorService.salvar(autor);

        return "redirect:/autores";
    }
    
}