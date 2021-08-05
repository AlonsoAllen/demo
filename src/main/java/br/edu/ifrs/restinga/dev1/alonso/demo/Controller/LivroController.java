package br.edu.ifrs.restinga.dev1.alonso.demo.Controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Id;
import javax.xml.crypto.Data;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.restinga.dev1.alonso.demo.Model.Objeto.Livro;
import br.edu.ifrs.restinga.dev1.alonso.demo.Repository.LivroRepository;


@RestController
@RequestMapping("/livro")
public class LivroController {    
	
	@Autowired
	private LivroRepository livroRepository;
	            
    @GetMapping
    public List<Livro> ListarLivros() {
        return livroRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Livro> BuscarLivro(@PathVariable Integer id){ 
    	Livro livroExistente = livroRepository.getById(id);
    	try {
    		return ResponseEntity.ok(livroExistente);
		} catch (Exception e) {
    		return ResponseEntity.notFound().build();
		}
    }       
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) 
    public ResponseEntity<Livro> postLivro (@RequestBody Livro livro){    	
    	livroRepository.save(livro);
    	
    	if ((livro.getTitulo() == null) || 
    			(livro.getEditor() == null) || 
    			(livro.getAutorPrimeiroNome() == null)) 
    	{
    		livroRepository.delete(livro);
    		return ResponseEntity.badRequest().build();
    	}  
    	
    	if ((Integer.parseInt(livro.getAnoPublicacao()) < 1800) ||
    		(Integer.parseInt(livro.getAnoPublicacao()) >  Calendar.getInstance().get(Calendar.YEAR))) 
    	{
    		livroRepository.delete(livro);
    		return ResponseEntity.badRequest().build();
    	}    	
    	
        return ResponseEntity.ok(livro);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Livro> putLivro (@PathVariable Integer id, @RequestBody Livro livro) {
    	Livro livroExistente = livroRepository.getById(id);
    	BeanUtils.copyProperties(livro, livroExistente, "id"); // serve para usar somente o id que já está no banco
    	
    	livroExistente = livroRepository.save(livroExistente);
    	
    	return ResponseEntity.ok(livroExistente);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Integer id){
    	Livro livro = livroRepository.getById(id);
    	
    	if (livro == null) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	livroRepository.delete(livro);
    	
    	return ResponseEntity.noContent().build();
    }    

}