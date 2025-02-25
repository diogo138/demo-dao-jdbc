package model.DAO;

import java.util.List;

import model.entities.Livros;

public interface LivrosDAO {
	void insert(Livros livro);

	void update(Livros livro);

	void deleteById(Integer id);

	Livros findById(Integer id);

	List<Livros> findAll();
}
