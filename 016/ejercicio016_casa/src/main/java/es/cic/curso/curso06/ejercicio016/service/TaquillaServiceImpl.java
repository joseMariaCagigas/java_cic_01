package es.cic.curso.curso06.ejercicio016.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.curso06.ejercicio016.repository.TaquillaRepository;


@Service
public class TaquillaServiceImpl {

	@Autowired
	private TaquillaRepository repository;

	public TaquillaRepository getRepository() {
		return repository;
	}

	public void setRepository(TaquillaRepository repository) {
		this.repository = repository;
	}

	
	
}
