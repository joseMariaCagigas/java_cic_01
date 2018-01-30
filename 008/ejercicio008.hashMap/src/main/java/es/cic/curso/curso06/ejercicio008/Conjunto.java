package es.cic.curso.curso06.ejercicio008;

import java.util.HashSet;

public class Conjunto {
	private HashSet<Integer> coleccion = new HashSet<Integer>();
			
	public void inicializa(){
			
		for(Integer i = 0; i < 100; i++){
			coleccion.add(i*i*i);
		}	
	}
	
	public boolean esCubo(int numero){
		boolean esCubo = coleccion.contains(numero);	
		
		return esCubo;
	}
	
	public int sumaCubos(){
		int resultado = 0;
		for(Integer valor: coleccion){
			resultado += valor;
		}
	return resultado;
	}
		
}
