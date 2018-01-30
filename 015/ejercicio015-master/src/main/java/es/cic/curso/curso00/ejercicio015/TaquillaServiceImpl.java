package es.cic.curso.curso00.ejercicio015;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaquillaServiceImpl extends Object implements TaquillaService {

	
	@Autowired 
	private SalaRepository salaRepository;

	public double vender(long salaId, long sesionId, int numeroEntradas) {
		salaRepository.add(new Sala(salaId));
		return 0;
	}

	public SalaRepository getJoseCarlos() {
		return salaRepository;
	}

	public void setJoseCarlos(SalaRepository salaRepository) {
		this.salaRepository = salaRepository;
	}

}
