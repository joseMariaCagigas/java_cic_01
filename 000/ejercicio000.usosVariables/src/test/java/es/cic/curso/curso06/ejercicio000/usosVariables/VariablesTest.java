package es.cic.curso.curso06.ejercicio000.usosVariables;

import org.junit.Before;
import org.junit.Test;

public class VariablesTest {
	
	private Variables cut;

	@Before
	public void setUp() throws Exception {
		cut = new Variables();
	}

	@Test
	public void testVariables() {

		int resultado = cut.imprimir(22, 11, 89, true);

	}

}
