package es.cic.curso.curso06.ejercicio017;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFigura {
	
	@Autowired
	private RepositoryFiguraImpl figuraRepository;

	public RepositoryFiguraImpl getFiguraRepository() {
		return figuraRepository;
	}

	public void setFiguraRepository(RepositoryFiguraImpl figuraRepository) {
		this.figuraRepository = figuraRepository;
	}
}
