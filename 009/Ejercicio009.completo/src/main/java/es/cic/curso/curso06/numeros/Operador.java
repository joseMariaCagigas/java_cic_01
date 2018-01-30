package es.cic.curso.curso06.numeros;

import java.util.ArrayList;
import java.util.List;

public class Operador {

	private ConjuntoNumeros conj;
	
	public Operador(){
		conj = new ConjuntoNumeros();
	}
	
	public boolean esPar(int i){
		List<Integer> listaP = new ArrayList<Integer>();
		listaP=conj.getPares();
		for(int j=0;j<listaP.size();j++){
			if(i==listaP.get(j))
				return true;
		}
		return false;
	}
	public boolean esImpar(int i){
		List<Integer> listaI = new ArrayList<Integer>();
		listaI=conj.getImpares();
		for(int j=0;j<listaI.size();j++){
			if(i==listaI.get(j))
				return true;
		}
		return false;
	}

	
}
