package application;
import java.util.Date;

import model.entities.StatusUsuario;
import model.entities.Usuario;

public class Program {

	public static void main(String[] args) {
		Usuario usuario = new Usuario("Maria", "maria@gmail.com", "123", new Date(), StatusUsuario.ativo);
		System.out.println(usuario);
	}

}
