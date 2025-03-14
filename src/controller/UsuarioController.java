package controller;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import model.DAO.impl.UsuarioDAOJDBC;
import model.entities.Usuario;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.util.List;

public class UsuarioController {
	private UsuarioDAOJDBC usuarioDAO;
	
	public UsuarioController(Connection conn) {
		this.usuarioDAO = new UsuarioDAOJDBC(conn);
	}
	
	public void startServer() throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
		server.createContext("/usuarios", new UsuariosHandler());
		server.setExecutor(null);
		server.start();
		System.out.println("Servidor rodando em http://localhost:8080/usuarios");
	}
	
	class UsuariosHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                List<Usuario> usuarios = usuarioDAO.findAll();
                String response = usuarios.toString(); // Simples, mas idealmente você deveria converter para JSON
                
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                String response = "Método não permitido";
                exchange.sendResponseHeaders(405, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
