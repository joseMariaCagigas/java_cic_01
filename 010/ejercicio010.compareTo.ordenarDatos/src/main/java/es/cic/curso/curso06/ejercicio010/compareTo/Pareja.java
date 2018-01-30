package es.cic.curso.curso06.ejercicio010.compareTo;

public class Pareja {
	private Persona izquierda;
	private Persona derecha;
	private PersonaComparador comparador;
	
	public void recibirPersonas(Persona p, Persona r){
		
		//PersonaComparador comparador = new PersonaPorEdadComparadorImpl();
		
		if(getComparador().comparar(p, r) <= 0){
			setIzquierda(p);
			setDerecha(r);
		}else{
			setIzquierda(r);
			setDerecha(p);
		}
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
}


