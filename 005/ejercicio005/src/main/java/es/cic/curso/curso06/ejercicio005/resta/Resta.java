package es.cic.curso.curso06.ejercicio005.resta;

import static es.cic.curso.curso06.ejercicio005.VariosHelper.imprimir;

public class Resta {
	
	private hashteger;
	
	//creamos un método
	public int restando(){
		
		int suma = 0;

		
		for(int i = 0, valor = 200; i < operacion.length; i++, valor -= 3){
			
			operacion[i] = valor;
							
		}
		
		for(int i = operacion.length -1; i <= 0; i--){
			suma += operacion[i];
		}
		
		imprimir("La suma de la operación es ; " +suma);
		
		return suma;
	}


	
}
