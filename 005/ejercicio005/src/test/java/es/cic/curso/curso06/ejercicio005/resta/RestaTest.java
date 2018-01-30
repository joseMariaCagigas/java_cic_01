package es.cic.curso.curso06.ejercicio005.resta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.cic.curso.curso06.ejercicio005.estimacion.Estimador;

public class RestaTest {
	
	private Resta sut;

	@Before
	public void setUp() throws Exception {
		sut = new Resta();
	}

	@Test
	public void test() {
		
		int res = sut.restando();
		
		assertEquals(5150, res);
		
	}

}
