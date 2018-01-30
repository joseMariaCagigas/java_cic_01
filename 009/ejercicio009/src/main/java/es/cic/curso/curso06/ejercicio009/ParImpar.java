package es.cic.curso.curso06.ejercicio009;

import java.util.HashMap;
import java.util.Map;



public class ParImpar {

	public static final int MIL = 1000;
	private Map<Integer, Integer> MapaParImpar = new HashMap<>();
	
	public ParImpar(){
		inicializa();
	}
	
	private void inicializa(){
		
		for(int i = 0 ; i < MIL ; i++){
			MapaParImpar.put(i, (i%2));
		}
	}
	
	public boolean EsPar(int valor){
		boolean res = false;
		valor = MapaParImpar.get(valor);
		
		if (valor == 0){
			res = true;
		}
		return res;
	}
	

	

}