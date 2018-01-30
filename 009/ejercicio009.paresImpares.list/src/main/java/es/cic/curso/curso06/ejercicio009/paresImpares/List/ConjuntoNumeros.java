package es.cic.curso.curso06.ejercicio009.paresImpares.List;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoNumeros {
	
	private List<Integer> pares;
	private List<Integer> impares;

	public ConjuntoNumeros() {
		pares = new ArrayList<Integer>();
		impares = new ArrayList<Integer>();
		inicializaPares();
		inicializaImpares();
	}

	public List<Integer> getPares() {
		return pares;
	}
	
	public List<Integer> getImpares() {
		return impares;
	}

	private void inicializaPares() {
		for(int i = 0; 1<1000; i = i+2)
		pares.add(i);
	}

	private void inicializaImpares() {
		for(int i = 1; 1<1000; i = i+2)
		impares.add(i);
	}

}
