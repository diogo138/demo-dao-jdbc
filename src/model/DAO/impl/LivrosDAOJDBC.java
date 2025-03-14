package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.DAO.LivrosDAO;
import model.entities.Livros;

public class LivrosDAOJDBC implements LivrosDAO {
	private Connection conn;
	
	public LivrosDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
 	public void insert(Livros livro) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "Insert into livros (titulo, autor, genero, ano_publicacao, quantidade, status) values (?, ?, ?, ?, ?, ?)";
			st = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			st.setString(1, livro.getTitulo());
			st.setString(2, livro.getAutor());
			st.setString(3, livro.getGenero());
			st.setInt(4, livro.getAno());
			st.setInt(5, livro.getQuantidade());
			st.setString(6, livro.getStatus().toString());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					livro.setId(id);
				}
			} else {
	            throw new DbException("Erro inesperado! Nenhuma linha foi inserida.");
	        }
		} catch (SQLException e) {
	        throw new DbException(e.getMessage());
	    } finally {
	        DB.closeStatement(st);
	        DB.closeResultSet(rs);
	    }
		
	}

	@Override
	public void update(Livros livro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Livros findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livros> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
