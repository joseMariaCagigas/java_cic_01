package es.cic.curso.curso06.ejercicio005.estimacion;

import static es.cic.curso.curso06.ejercicio005.VariosHelper.imprimir;

import java.lang.reflect.Array;

public class Estimador {

	private int[] alumno = new int[] {16, 19};// ahora mismo todos los valores van a 0
		
	//creamos un método
	public int estimar(){
		
		imprimir("Tamaño de la  clase; " +alumno.length+ ".");
				
		int suma = 0;
		
		for(int i = 0 ; i < alumno.length; i++){
			suma += alumno[i];
		}
		imprimir("Suma; " +suma);
		
		return suma / alumno.length;
	}
	
	//creamos un método
	
	public int estimarWhile() {
		
		int suma = 0;
		int i = 0;
		
		while (i < alumno.length) {
			// asi le sumando el anterior continuamente
			suma += alumno[i];
			i++;
		}
		
		return suma / alumno.length;
		
	}
	
	//creamos un método
	
	public int estimarDoWhile() {
		
		int suma = 0;
		int i = 0;
		
		do{
			suma += alumno[i];
			i++;
		}
		while (i < alumno.length);
		
		return suma / alumno.length;
		
	}
}
