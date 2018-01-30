package es.cic.curso.curso06.ejercicio005.estimacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EstimacionTest {
	
	private Estimador sut;

	@Before
	public void setUp() throws Exception {
		sut = new Estimador();
	}

	@Test
	public void testEstimar() {
		
		int res = sut.estimar();
		
		assertEquals("No es el número que esperaba",17, res);
		
	}
	@Test
	public void testEstimarWhile() {
		
		int res = sut.estimarWhile();
		
		assertEquals("No es el número que esperaba",17, res);
		
	}
	
	@Test
	public void testEstimarDoWhile() {
		
		int res = sut.estimarDoWhile();
		
		assertEquals("No es el número que esperaba",17, res);
		
	}
}
