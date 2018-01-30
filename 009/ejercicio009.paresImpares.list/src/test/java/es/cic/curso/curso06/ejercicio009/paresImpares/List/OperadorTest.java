package es.cic.curso.curso06.ejercicio009.paresImpares.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.cic.curso.curso06.ejercicio009.paresImpares.List.Operacion;

public class OperadorTest {

	private Operacion sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new Operacion();
	}

	@Test
	public void testParOImpar() {;
		assertTrue(sut.esPar(2));
		assertTrue(sut.esImpar(5));
		assertFalse(sut.esPar(9));
		assertFalse(sut.esImpar(4));
		
	}

}
