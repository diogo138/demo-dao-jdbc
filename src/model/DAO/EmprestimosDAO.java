package model.DAO;

import java.util.List;

import model.entities.Emprestimos;

public interface EmprestimosDAO {
	void insert(Emprestimos emprestimo);

	void update(Emprestimos emprestimo);

	void deleteById(Integer id);

	Emprestimos findById(Integer id);

	List<Emprestimos> findAll();
}
