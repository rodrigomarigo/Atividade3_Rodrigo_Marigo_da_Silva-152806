package com.example.atividade03_rodrigo_marigo_da_silva_152806.Controller;

import java.util.List;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Autor;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Livro;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.AutorService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.EditoraService;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private LivroService livroService;

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

    @PostMapping("/associarLivroAutor")
    public String associarLivro(@ModelAttribute Livro livro, @RequestParam Integer idAutor) {
        Autor autor = autorService.getAutorById(idAutor);
        livro = livroService.getLivroById(livro.getId());

        autor.getLivros().add(livro);
        autorService.salvar(autor);

        return "redirect:/detalhesAutor/" + idAutor;
    }

    @GetMapping("/detalhesControle/{codigo}")
    public ModelAndView getLivroDetalhes(@PathVariable(name = "codigo") Integer codigo) {

        Autor autor = autorService.getAutorById(codigo);
        ModelAndView mv = new ModelAndView("detalhesAutor");
        mv.addObject("autor", autor);
        List<Livro> livrosNaoAssociados = livroService.getLivros();
        livrosNaoAssociados.removeAll(autor.getLivros());
        mv.addObject("livros", livrosNaoAssociados);

        return mv;
    }
    
}