package br.edu.ifrs.restinga.dev1.alonso.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.edu.ifrs.restinga.dev1.alonso.demo.Model.Livro;
import br.edu.ifrs.restinga.dev1.alonso.demo.Repository.LivroRepository;


@RestController
@RequestMapping("/livro")
public class LivroController {    
	
	@Autowired
	private LivroRepository livroRepository;
            
    @GetMapping
    public List<Livro> getLivro() {
        return livroRepository.findAll();
    }
    
    @PostMapping
    public Livro postLivro (@RequestBody Livro livro){
        return livroRepository.save(livro);
    }

}