package com.example.atividade03_rodrigo_marigo_da_silva_152806.Controller;

import java.util.List;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Autor;
import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Editora;
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

    @PostMapping("/associarLivroAutor")
    public String associarAutor(@ModelAttribute Autor autor, @RequestParam Integer idLivro) {
        Livro livro = livroService.getLivroById(idLivro);
        autor = autorService.getAutorById(autor.getId());

        livro.getAutor().add(autor);
        livroService.salvar(livro);

        return "redirect:/detalhesLivro/" + idLivro;
    }

    @PostMapping("/associarLivroEditora")
    public String associarEditora(@ModelAttribute Editora editora, @RequestParam Integer idLivro) {
        Livro livro = livroService.getLivroById(idLivro);
        editora = editoraService.getEditoraById(editora.getId());

        livro.setEditora(editora);
        livroService.salvar(livro);

        return "redirect:/detalhesLivro/" + idLivro;
    }

    @GetMapping("/detalhesLivro/{id}")
    public ModelAndView getLivroDetalhes(@PathVariable(name = "id") Integer id) {

        Livro livro = livroService.getLivroById(id);
        ModelAndView mv = new ModelAndView("detalhesLivro");    
        mv.addObject("livro", livro);
        List<Autor> autoresNaoAssociados = autorService.getAutores();
        autoresNaoAssociados.removeAll(livro.getAutor());
        mv.addObject("autores", autoresNaoAssociados);
        List<Editora> editorasNaoAssociadas = editoraService.getEditoras();
        editorasNaoAssociadas.remove(livro.getEditora());
        mv.addObject("editoras", editorasNaoAssociadas);

        return mv;
    }

    @GetMapping("/removerLivro")
    public String removerLivro(@RequestParam Integer id) {
        Livro livro = livroService.getLivroById(id);
        livroService.remover(livro);

        return "redirect:/livros";
    }
    
    @GetMapping("/editarLivro")
    public ModelAndView editarLivro(@RequestParam Integer id){
        ModelAndView mv = new ModelAndView("livroEdit");

        Livro livro = livroService.getLivroById(id);
        mv.addObject("livro", livro);
        mv.addObject("editoras", editoraService.getEditoras());
        mv.addObject("autores", autorService.getAutores());

        return mv;
    }

}