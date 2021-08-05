package br.edu.ifrs.restinga.dev1.alonso.demo.Model.Objeto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String titulo;
	private String autorPrimeiroNome;
	private String autorSegundoNome;
	private String anoPublicacao;
	private String editor;
	private boolean doacao;
	
	public String getAutorPrimeiroNome() {
		return autorPrimeiroNome;
	}

	public void setAutorPrimeiroNome(String autorPrimeiroNome) {
		this.autorPrimeiroNome = autorPrimeiroNome;
	}

	public String getAutorSegundoNome() {
		return autorSegundoNome;
	}

	public void setAutorSegundoNome(String autorSegundoNome) {
		this.autorSegundoNome = autorSegundoNome;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public boolean isDoacao() {
		return doacao;
	}

	public void setDoacao(boolean doacao) {
		this.doacao = doacao;
	}

	public Livro() {
		
	}
	
	public Livro (Integer id, String titulo) {
        super();
        this.id = id; 
        this.titulo = titulo;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}


