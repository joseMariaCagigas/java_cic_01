package es.cic.curso.curso06.ejercicio009;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.cic.curso.curso06.numeros.Operador;

public class OperadorTest {

	private Operador sut;
	@Before
	public void setUp() throws Exception {
		sut = new Operador();
	}

	@Test
	public void testParOImpar() {;
		assertTrue(sut.esPar(2));
		assertTrue(sut.esImpar(5));
		assertFalse(sut.esPar(9));
		assertFalse(sut.esImpar(4));
		
	}

}
