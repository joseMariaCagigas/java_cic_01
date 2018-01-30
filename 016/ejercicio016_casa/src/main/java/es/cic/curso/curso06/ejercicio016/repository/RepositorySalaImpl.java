package es.cic.curso.curso06.ejercicio016.repository;

import es.cic.curso.curso06.ejercicio016.domain.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class RepositorySalaImpl implements RepositorySala {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Sala create(Sala element) {
		manager.persist(element);
		return element;
	}

	@Override
	public Sala read(Long id) {
		Sala resultado = manager.find(Sala.class, id);
		return resultado;
	}

	@Override
	public Sala update(Sala element) {
		element = manager.merge(element);
		return element;
	}

	@Override
	public Sala delete(Long id) {
		Sala sala = new Sala();
		sala.setId(id);
		Sala resultado = manager.merge(sala);
		manager.remove(resultado);
		return resultado;
	}

	@Override
	public List<Sala> list() {
		return manager.createNativeQuery("SELECT * FROM SALA", Sala.class).getResultList();
	}

}
