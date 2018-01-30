package es.cic.curso15.ejercicio016;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GestionCineRepository {
	
	List<Sesion> sesionesSala = new ArrayList<>();
	List<SalaCine> salasCine = new ArrayList<>();
	
	public List<Sesion> anadirSala(Sesion sesion){
		sesionesSala.add(sesion);
		return sesionesSala;
	}
	
	public List<SalaCine> insertarNuevoCine(SalaCine sala){
		salasCine.add(sala);
		
		return salasCine;
	}
	
	
}
