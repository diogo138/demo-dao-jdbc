package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Emprestimos implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Usuario usuarios;
	private Livros livros;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private StatusEmprestimos status;
	
	public Emprestimos() {
	}

	public Emprestimos(Usuario usuarios, Livros livros, Date dataEmprestimo, Date dataDevolucao,
			StatusEmprestimos status) {
		this.usuarios = usuarios;
		this.livros = livros;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public Livros getLivros() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public StatusEmprestimos getStatus() {
		return status;
	}

	public void setStatus(StatusEmprestimos status) {
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
		Emprestimos other = (Emprestimos) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Emprestimos [usuarios=" + usuarios + ", livros=" + livros + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucao=" + dataDevolucao + ", status=" + status + "]";
	}
	
	
}
