package es.cic.curso.curso06.ejercicio018.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.curso06.ejercicio018.dominio.Cine;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CineDAOImpl implements CineDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Cine crea(Cine nuevo) {
		entityManager.persist(nuevo);
		return nuevo;
	}

}
