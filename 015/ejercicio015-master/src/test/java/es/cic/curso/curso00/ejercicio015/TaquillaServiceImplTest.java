package es.cic.curso.curso00.ejercicio015;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;


public class TaquillaServiceImplTest {


	private TaquillaServiceImpl ts;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testVender() {
		
		assertNotNull("No me ha devuelto nada", ts);
				
		assertNotNull("No tiene la referencia", ts.getJoseCarlos());
	}
}
