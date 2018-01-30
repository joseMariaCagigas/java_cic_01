package es.cic.curso.curso06.ejercicio016.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.curso06.ejercicio016.domain.*;

@Repository
@Transactional
public class RepositorySesionImpl implements RepositorySesion {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Sesion create(Sesion element) {
		manager.persist(element);
		return element;
	}

	@Override
	public Sesion read(Long id) {
		Sesion resultado = manager.find(Sesion.class, id);
		return resultado;
	}

	@Override
	public Sesion update(Sesion element) {
		element = manager.merge(element);
		return element;
	}

	@Override
	public Sesion delete(Long id) {
		Sesion sesion = new Sesion();
		sesion.setId(id);
		Sesion resultado = manager.merge(sesion);
		manager.remove(resultado);
		return resultado;
	}

	@Override
	public List<Sesion> list() {
		return manager.createNativeQuery("SELECT * FROM SESION", Sesion.class).getResultList();
	}



}
