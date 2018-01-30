package es.cic.curso.curso06.ejercicio016.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso.curso06.ejercicio016.service.TaquillaServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:es/cic/curso/curso06/ejercicio016/applicationContext.xml")

public class GestionTaquillaServiceTest {

	@Autowired
	private TaquillaServiceImpl sut;
	private int numEntradas;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testInyeccionDependencias() {
		assertNotNull(sut);
		assertNotNull(sut.getRepository());
	}
	
	@Test
	public void testVendeEntradas() {
		int numEntradas = 5;
		int numSala = 1;
		int numSesion = 0;
		
		sut.getRepository().venderEntradas(numEntradas, numSala, numSesion);
		
		int entradasLibres = sut.getRepository().verButacasLibres(numSala, numSesion);
		int entradasOcupadas = sut.getRepository().verButacasOcupadas(numSala, numSesion); 
		
		
		assertEquals(entradasLibres, 45);
		assertEquals(entradasOcupadas, 5);
		
	}
	
	@Test
	public void testRecaudacion() {
		
				
		sut.getRepository().venderEntradas(30, 2, 2);
		System.out.print(numEntradas);
		
		int recaudacion = sut.getRepository().calcularRecaudacion();
		System.out.print("Esta es la recaudación:" + recaudacion);
		assertFalse(recaudacion == 2490);
		assertTrue(recaudacion == 175);

		
	}
	
	
}
