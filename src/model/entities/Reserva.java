package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Reserva implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Usuario usuarios;
	private Livros livros;
	private Date dataReserva;
	private Date dataExpiracao;
	private StatusReserva status;
	
	public Reserva() {
	}

	public Reserva(Usuario usuarios, Livros livros, Date dataReserva, Date dataExpiracao, StatusReserva status) {
		super();
		this.usuarios = usuarios;
		this.livros = livros;
		this.dataReserva = dataReserva;
		this.dataExpiracao = dataExpiracao;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public StatusReserva getStatus() {
		return status;
	}

	public void setStatus(StatusReserva status) {
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
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", usuarios=" + usuarios + ", livros=" + livros + ", dataReserva=" + dataReserva
				+ ", dataExpiracao=" + dataExpiracao + ", status=" + status + "]";
	}
	
	
}
