package es.cic.curso.curso06.ejercicio008;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConjuntoTest {
	private Conjunto cut;

	
	@Before
	public void setUp() throws Exception {
		cut = new Conjunto();
		cut.inicializa();
	}

	@Test
	public void testEsCubo() {
		boolean esCubo = cut.esCubo(0);
		assertTrue(esCubo == true);
	}

}
