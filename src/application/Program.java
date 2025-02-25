package application;
import java.util.Date;

import model.entities.Emprestimos;
import model.entities.Livros;
import model.entities.StatusEmprestimos;
import model.entities.StatusUsuario;
import model.entities.Usuario;

public class Program {

	public static void main(String[] args) {
		Usuario usuario = new Usuario("Maria", "maria@gmail.com", "123", new Date(), StatusUsuario.ativo);
		
		Livros livro = new Livros("Clean Code", "Robert C. Martin", "TI", 40, 2008, "disponivel");
		
		Emprestimos emprestimo = new Emprestimos(usuario, livro, new Date(), null, StatusEmprestimos.pendente);
		System.out.println(emprestimo);
	}

}
