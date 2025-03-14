package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.DAO.UsuarioDAO;
import model.entities.StatusUsuario;
import model.entities.Usuario;

public class UsuarioDAOJDBC implements UsuarioDAO {
	private Connection conn;
	
	public UsuarioDAOJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Usuario usuario) {
		 PreparedStatement st = null;
		    ResultSet rs = null;

		    try {
		        String sql = "INSERT INTO usuarios (nome, email, senha, data_cadastro, status) VALUES (?, ?, ?, ?, ?)";
		        st = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

		        st.setString(1, usuario.getNome());
		        st.setString(2, usuario.getEmail());
		        st.setString(3, usuario.getSenha());
		        st.setTimestamp(4, new java.sql.Timestamp(usuario.getDataCadastro().getTime()));
		        st.setString(5, usuario.getStatus().toString());

		        int rowsAffected = st.executeUpdate();

		        if (rowsAffected > 0) {
		            rs = st.getGeneratedKeys();
		            if (rs.next()) {
		                int id = rs.getInt(1);
		                usuario.setId(id);
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
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE usuarios SET nome = ?, email = ?, data_cadastro = ?, status = ? WHERE id = ?");
			st.setString(1, usuario.getNome());
			st.setString(2, usuario.getEmail());
			st.setTimestamp(3, new java.sql.Timestamp(usuario.getDataCadastro().getTime()));
			st.setString(4, usuario.getStatus().toString());
			st.setInt(5, usuario.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public Usuario findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if( rs.next() ) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataCadastro(rs.getDate("data_cadastro"));
				usuario.setStatus(StatusUsuario.valueOf(rs.getString("status")));
				
				return usuario;
				}
			} catch (SQLException e) {
                throw new DbException(e.getMessage());
            } finally {
                DB.closeStatement(st);
                DB.closeResultSet(rs);
            }
		return null;
           
		}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM usuarios");
			rs = st.executeQuery();

			List<Usuario> list = new ArrayList<>();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataCadastro(rs.getTimestamp("data_cadastro"));
				String statusStr = rs.getString("status");
	            usuario.setStatus(statusStr != null ? StatusUsuario.valueOf(statusStr) : null);

				list.add(usuario);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
