package com.example.atividade03_rodrigo_marigo_da_silva_152806.Controller;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Livro;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.AutorService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.EditoraService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LivroController {
    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditoraService editoraService;

    @GetMapping("/livros")
    public ModelAndView getLivros() {
        ModelAndView mv = new ModelAndView("livrosTemplate");
        
        mv.addObject("livro", new Livro());
        mv.addObject("livros", livroService.getLivros());
        mv.addObject("autores", autorService.getAutores());
        mv.addObject("editoras", editoraService.getEditoras());

        return mv;
    }
    
    @PostMapping("/salvarLivro")
    public String salvar(@ModelAttribute Livro livro){
        livroService.salvar(livro);

        return "redirect:/livros";
    }


}