package es.cic.curso.curso06.ejercicio009.parImpar;

import java.util.HashMap;
import java.util.Map;



public class ParImpar {

	public static final int MIL = 1000;
	private Map<Integer, Integer> MapParImpar = new HashMap<>();
	
	public ParImpar(){
		inicializa();
	}
	
	private void inicializa(){
		
		for(int i = 0 ; i < MIL ; i++){
			MapParImpar.put(i, (i%2));
		}
	}
	
	public boolean EsPar(int valor){
		boolean resultado = false;
		valor = MapParImpar.get(valor);
		
		if (valor == 0){
			resultado = true;
		}
		return resultado;
	}
	

	

}