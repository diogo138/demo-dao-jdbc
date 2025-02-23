package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Livros implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String autor;
	private String genero;
	private Integer quantidade;
	private Integer ano;
	private StatusLivro status;
	
	public Livros() {
	}
	
	public Livros(String titulo, String autor, String genero, Integer quantidade, Integer ano,
			String status) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.quantidade = quantidade;
		this.ano = ano;
		this.status = StatusLivro.valueOf(status);
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public StatusLivro getStatus() {
		return status;
	}

	public void setStatus(StatusLivro status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livros other = (Livros) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Livros [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", quantidade="
				+ quantidade + ", ano=" + ano + ", status=" + status + "]";
	}
	
	
}
