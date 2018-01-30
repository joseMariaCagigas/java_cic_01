package es.cic.curso.curso06.ejercicio000.comparacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParejaTest {
	
	private Pareja sut;

	@Before
	public void setUp() throws Exception {
		this.sut = new Pareja();
	}

	@Test
	public void testRecibirPersonas() {
		Persona mayor = new Persona();
		mayor.setEdad(44);
		
		Persona menor = new Persona();
		menor.setEdad(22);
		
		sut.recibirPersonas(menor, mayor);
		
		assertEquals(mayor, sut.getIzquierda());
	}

}
