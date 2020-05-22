package com.example.atividade03_rodrigo_marigo_da_silva_152806.Controller;

import com.example.atividade03_rodrigo_marigo_da_silva_152806.Entity.Editora;
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
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @Autowired
    private LivroService livroService;

    @GetMapping("/editoras")
    public ModelAndView getEditoras() {
        ModelAndView mv = new ModelAndView("editorasTemplate");
        
        mv.addObject("editora", new Editora());
        mv.addObject("editoras", editoraService.getEditoras());

        return mv;
    }

    @GetMapping("/detalhesEditora/{codigo}")
    public ModelAndView getEditoraDetalhes(@PathVariable(name = "codigo") Integer codigo) {

        Editora editora = editoraService.getEditoraById(codigo);
        ModelAndView mv = new ModelAndView("detalhesEditora");
        mv.addObject("editora", editora);

        return mv;
    }

    @PostMapping("/salvarEditora")
    public String salvar(@ModelAttribute Editora editora){
        editoraService.salvar(editora);

        return "redirect:/editoras";
    }

    @GetMapping("/removerEditora")
    public String removerLivro(@RequestParam Integer id) {
        Editora editora = editoraService.getEditoraById(id);
        editoraService.remover(editora);

        return "redirect:/editoras";
    }

    @GetMapping("/editarEditora")
    public ModelAndView editarEditora(@RequestParam Integer id){
        ModelAndView mv = new ModelAndView("editoraEdit");

        Editora editora = editoraService.getEditoraById(id);
        mv.addObject("editora", editora);
        mv.addObject("livros", livroService.getLivros());

        return mv;
    }
    
}