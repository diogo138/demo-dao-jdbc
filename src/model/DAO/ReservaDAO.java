package model.DAO;

import java.util.List;

import model.entities.Reserva;

public interface ReservaDAO {
	void insert(Reserva reserva);

	void update(Reserva reserva);

	void deleteById(Integer id);

	Reserva findById(Integer id);

	List<Reserva> findAll();
}
