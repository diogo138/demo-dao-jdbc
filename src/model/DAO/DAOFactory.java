package model.DAO;

import db.DB;
import model.DAO.impl.UsuarioDAOJDBC;

public class DAOFactory {
	public static UsuarioDAO createUsuarioDAO() {
		return new UsuarioDAOJDBC(DB.getConnection());
	}
}
