package es.cic.curso.curso06.ejercicio009.parImpar.list;

import es.cic.curso.curso06.ejercicio009.parImpar.list.Par;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParTest {
	
	private Par cut;

	@Before
	public void setUp() throws Exception {
		cut = new Par();
		cut.calcular();
	}

	@Test
	public void testParVerdadero() {
		boolean res = cut.esPar(2);
		assertEquals(true, res);
		
	}
	
	@Test
	public void testParFalso() {
		boolean res = cut.esPar(3);
		assertEquals(false, res);
		
	}


}