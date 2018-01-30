package es.cic.curso.curso06.ejercicio010.compareTo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParejaTest {
	
	private Pareja sut;
	
	private List<Persona> personas;

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	@Before
	
	public void setUp() throws Exception {
		
		this.sut = new Pareja();
		sut.setComparador(new PersonaPorEdadComparadorImpl());
		sut.setPersonas(personas = new ArrayList<>());
		
		personas.add(new Persona("Fliex", 33));
		personas.add(new Persona("Tom", 29));
		personas.add(new Persona("Karl", 31));
		personas.add(new Persona("George", 32));
		
		//Ordenamos la lista
		sut.PersonasLista(sut.getPersonas());		
	}
	@Test
	public void testOrdenarPorNombre() {
		
		//Comprueba que la Lista Está Ordenada
		equals(sut.getPersonas().get(3));
		equals(sut.getPersonas().get(2));
		equals(sut.getPersonas().get(1));
		equals(sut.getPersonas().get(0));
	}
	

	@Test
	public void testComprobarOrdenador() {

		Persona mayor =  new Persona();
		mayor.setEdad(33);
		
		Persona menor = new Persona();
		menor.setEdad(22);
				
				
		sut.recibirPersonas(menor, mayor);
		assertEquals(mayor, sut.getIzquierda());
	}


}
