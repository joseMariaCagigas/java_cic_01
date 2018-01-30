package es.cic.curso.curso06.ejercicio010.ordenar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MainTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("-----Ordenado cadenas de texto-----");
		List<String> nombres = new ArrayList<String>();
		nombres.add("Paco Perez");
		nombres.add("José Alvarado");
		nombres.add("Pepe Argeta");
		nombres.add("Ariel Anonitmo");
		nombres.add("Ariel Maldnoado");
		nombres.add("Zulma Estrada");
		
		//Si el arraylist es de objetos primitivos como, String, Integer, etc.
		//basta con llamar al metodo sort.
		Collections.sort(nombres);
		
		for(String nombre : nombres){
			System.out.println(nombre);
		}
		
	
		List<Hijo> hijos = new ArrayList<Hijo>();
		hijos.add(new Hijo("Paco", "Perez", 20, new Date(11000)));
		hijos.add(new Hijo("Pepe", "Argeta", 23, new Date(9000)));
		hijos.add(new Hijo("Zulma", "Estrada", 18, new Date(10000)));
		
		
		System.out.println("-----Ordenado por Fecha-----");
		Collections.sort(hijos, new Comparator<Hijo>(){

			@Override
			public int compare(Hijo o1, Hijo o2) {
				return o1.getFechaRegistro().compareTo(o2.getFechaRegistro());
			}
			
			
		});
		
		for(Hijo hijo : hijos){
			System.out.println(hijo.getNombre());
		}
		
		System.out.println("-----Ordenado por Edad-----");
		Collections.sort(hijos, new Comparator<Hijo>(){

			@Override
			public int compare(Hijo o1, Hijo o2) {
				return o1.getEdad().compareTo(o2.getEdad());
			}
			
		});
		
		for(Hijo hijo : hijos){
			System.out.println(hijo.getNombre());
		}
		
	}

}
