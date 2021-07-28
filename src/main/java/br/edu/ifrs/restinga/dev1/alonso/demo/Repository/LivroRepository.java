package br.edu.ifrs.restinga.dev1.alonso.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.restinga.dev1.alonso.demo.Model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
