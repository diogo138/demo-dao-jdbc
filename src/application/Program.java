package application;
import java.io.IOException;
import java.sql.Connection;

import controller.UsuarioController;
import db.DB;

public class Program {

	public static void main(String[] args) throws IOException {
//		UsuarioDAO usuarioDAO = DAOFactory.createUsuarioDAO();
//		Usuario usuario = new Usuario("Joao", "joao@gmail.com", "123456", new Date(), StatusUsuario.ativo);
//		usuarioDAO.insert(usuario);
//		Usuario usuarioId = usuarioDAO.findById(1);
//		usuarioDAO.deleteById(usuarioId.getId());
//		usuarioId.setNome("João");
//	    usuarioDAO.update(usuarioId);
//		usuarioDAO.findAll().forEach(System.out::println);
		
		Connection conn = DB.getConnection();
		UsuarioController controller = new UsuarioController(conn);
		controller.startServer();
	}

}
