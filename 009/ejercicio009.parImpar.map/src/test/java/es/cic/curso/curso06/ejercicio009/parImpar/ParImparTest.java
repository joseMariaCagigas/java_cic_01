package es.cic.curso.curso06.ejercicio009.parImpar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParImparTest {
	
	private ParImpar sut;

	@Before
	public void setUp() throws Exception {
		sut = new ParImpar();
	}

	@Test
	public void testEsPar() {
		boolean res = sut.EsPar(2);
		assertTrue(res);
	}

	@Test
	public void testEsImpar() {
		boolean res = sut.EsPar(9);
		assertFalse(res);
	}
}