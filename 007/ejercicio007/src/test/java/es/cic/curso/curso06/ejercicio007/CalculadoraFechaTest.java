package es.cic.curso.curso06.ejercicio007;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.cic.curso.curso06.ejercicio007.CalculadoraFecha;
import es.cic.curso.curso06.ejercicio007.CalculadoraFechaImpl;

public class CalculadoraFechaTest {
	
	private CalculadoraFecha intermedia;

	@Before
	public void setUp() throws Exception {
		intermedia = new CalculadoraFechaImpl();
	}

	@Test
	public void testDiasHastaNavidad_DiaAntes() {

		int resultado = intermedia.diasHastaNavidad(24, 12);
		
		assertEquals("No es el valor esperado", 1, resultado);
	}
	
	@Test
	public void testDiasHastaNavidad_EsNavidad() {

		int resultado = intermedia.diasHastaNavidad(25, 12);
		
		assertEquals("No es el valor esperado", 0, resultado);
	}	
	
	@Test
	public void testDiasHastaNavidad_DiaDespues() {

		int resultado = intermedia.diasHastaNavidad(26, 12);
		
		assertEquals("No es el valor esperado", 364, resultado);
	}	
	
	@Test
	public void testDiasHastaNavidad_MismoMes() {

		int resultado = intermedia.diasHastaNavidad(12, 12);
		
		assertEquals("No es el valor esperado", 13, resultado);
	}
	
	@Test
	public void testDiasHastaNavidad_MesAnterior() {

		int resultado = intermedia.diasHastaNavidad(22, 11);
		
		assertEquals("No es el valor esperado", 33, resultado);
	}
	
	@Test
	public void testDiasHastaNavidad_CasiEsVerano() {

		int resultado = intermedia.diasHastaNavidad(13, 6);
		
		assertEquals("No es el valor esperado", 195, resultado);
	}	

}
