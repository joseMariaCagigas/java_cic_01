package es.cic.curso.curso06.ejercicio000.comparacion;

public class Pareja {

	private Persona izquierda;
	private Persona derecha;
	
	/*
	//coleccion indeterminada de elementos, usamos array
	public void recibirPersonas(Persona p, Persona r){
		recibirPersonas(p, r, new Persona());
	}
	
	//si quiero puedo colocar un argumento con los puntos suspensivos
	public void recibirPersonas(Persona... p){
		Persona pe = p[0];
	}
	*/
	//quiero ordenarlos
	
	public void recibirPersonas(Persona p, Persona r){
		if(p.comparar(r) <0){
			setIzquierda(p);
			setDerecha(r);
		}else{
			setIzquierda(r);
			setDerecha(p);
		}
	}
	
	public Persona getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(Persona izquierda) {
		this.izquierda = izquierda;
	}
	public Persona getDerecha() {
		return derecha;
	}
	public void setDerecha(Persona derecha) {
		this.derecha = derecha;
	}
	

}
