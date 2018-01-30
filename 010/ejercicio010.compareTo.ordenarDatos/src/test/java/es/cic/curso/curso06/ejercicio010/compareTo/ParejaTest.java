package es.cic.curso.curso06.ejercicio010.compareTo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParejaTest {
	
	private Pareja sut;

	@Before
	public void setUp() throws Exception {
		
		this.sut = new Pareja();
		sut.setComparador(new PersonaPorEdadComparadorImpl());
	}

	@Test
	public void test() {

		Persona mayor =  new Persona();
		mayor.setEdad(44);
		
		Persona menor = new Persona();
		menor.setEdad(22);
				
				
		sut.recibirPersonas(menor, mayor);
		assertEquals(mayor, sut.getIzquierda());
	}

}
