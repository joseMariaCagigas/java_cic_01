package es.cic.curso.curso06.ejercicio016.dto;

import java.util.ArrayList;
import java.util.List;

public class Taquilla {
	private List<Sala> salas = new ArrayList<>();
	private final int NUMSALA1 = 1;
	private final int NUMSALA2 = 2;
	private final int NUMSALA3 = 3;
	
	public Taquilla(){
		super();
		Sala sala1 = new Sala(NUMSALA1);
		Sala sala2 = new Sala(NUMSALA2);
		Sala sala3 = new Sala(NUMSALA3);
		
		salas.add(sala1);
		salas.add(sala2);
		salas.add(sala3);
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	
	
}
