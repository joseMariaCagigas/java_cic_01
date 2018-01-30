package es.cic.curso.curso06.ejercicio009.paresImpares.List;

import java.util.ArrayList;
import java.util.List;

public class Operacion {

	private ConjuntoNumeros conj;
	
	public Operacion(){
		conj = new ConjuntoNumeros();
	}
	
	public boolean esPar(int i){
		List<Integer> ParLista = new ArrayList<Integer>();
		ParLista=conj.getPares();
		for(int j=0;j<ParLista.size();j++){
			if(i==ParLista.get(j))
				return true;
		}
		return false;
	}
	public boolean esImpar(int i){
		List<Integer> ImparLista = new ArrayList<Integer>();
		ImparLista=conj.getImpares();
		for(int j=0;j<ImparLista.size();j++){
			if(i==ImparLista.get(j))
				return true;
		}
		return false;
	}

	
}
