package es.cic.curso.curso06.ejercicio010.compareTo;

import java.util.List;

public class Pareja {
	private Persona izquierda;
	private Persona derecha;
	private PersonaComparador comparador;
	private List<Persona> personas;
	
	public void recibirPersonas(Persona p, Persona r){
		
		//PersonaComparador comparador = new PersonaPorEdadComparadorImpl();
		
		getComparador();
		if(comparador.comparar(p, r) <= 0){
			setIzquierda(p);
			setDerecha(r);
		}else{
			setIzquierda(r);
			setDerecha(p);
		}
	}
	
	public void PersonasLista(List<Persona> listaDesordenada){
		
		for(int i = 0; i< listaDesordenada.size()-1; i++){		// Recorren la lista de personas
			Persona mayor = listaDesordenada.get(i);
			int posicion = i;									// El mayor de la lista
			for(int j = i+1; j < listaDesordenada.size(); j++){	// Recorremos el resto de la lista
				if(comparador.comparar(mayor, listaDesordenada.get(j))>0){
					mayor = listaDesordenada.get(j);
					posicion = j;
				}
			}
			listaDesordenada.set(posicion,listaDesordenada.get(i));
			listaDesordenada.set(i,mayor);
		}
		setPersonas(listaDesordenada);
	}
	
/*	public void recibirPersonas( Persona... p ){ 
		//Los tres puntos suspensivos permiten pasar más de los argumentos dados
		Persona pe = p[0]; // Se puede pasar un Array
		*/
		
	public  Persona getIzquierda() {
		return izquierda;
	}
	private void setIzquierda(Persona izquierda) {
		this.izquierda = izquierda;
	}
	public Persona getDerecha() {
		return derecha;
	}
	private void setDerecha(Persona derecha) {
		this.derecha = derecha;
	}
	private PersonaComparador getComparador() {
		return comparador;
	}
	void setComparador(PersonaComparador comparador) {
		this.comparador = comparador;
	}
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
}


