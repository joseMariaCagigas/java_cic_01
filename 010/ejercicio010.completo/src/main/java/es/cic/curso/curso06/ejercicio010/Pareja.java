package es.cic.curso.curso06.ejercicio010;

import java.util.List;

public class Pareja
{
	//Attributes
	private Persona izquierda;
	private Persona derecha;
	private PersonaComparador personaComparador;
	private List<Persona> personasLista;

	//RecibirPersonas
	public void recibirPersonas(Persona p, Persona r)
	{
		if(personaComparador.comparar(p,r)<=0){
			setIzquierda(p);
			setDerecha(r);
		}else{
			setIzquierda(r);
			setDerecha(p);
		}
	}
	
	//RecibirPersonasColeccion
	public void recibirPersonasLista(List<Persona> listaP)
	{
		//Recorre la Parte No Ordenada de la Lista
		for(int p=0;p<listaP.size()-1;p++)
		{
			//Establece el Mayor para el Recorrido Actual
			Persona mayor = listaP.get(p);
			int posicion = p;
			//Recorre lo que Queda de Lista para Buscar Alguien Mayor
			for(int i=p+1;i<listaP.size();i++)
			{
				//Si Encuentra Alguien Mayor, lo Asigna y Anota su Posicion
				if(personaComparador.comparar(mayor,listaP.get(i))>0){
					mayor = listaP.get(i);
					posicion = i;
				}
			}
			//Tras Finalizar el Recorrido Asigna el Mayor a la Primera Posicion No Ordenada
			listaP.set(posicion,listaP.get(p));
			listaP.set(p,mayor);
		}
		//Guarda la Lista Ordenada
		setPersonasLista(listaP);
	}
	
///// GETTERS Y SETTERS /////
	
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
	
	public PersonaComparador getPersonaComparador() {
		return personaComparador;
	}
	public void setPersonaComparador(PersonaComparador personaComparador) {
		this.personaComparador = personaComparador;
	}
	
	public List<Persona> getPersonasLista() {
		return personasLista;
	}
	public void setPersonasLista(List<Persona> personasLista) {
		this.personasLista = personasLista;
	}
}
