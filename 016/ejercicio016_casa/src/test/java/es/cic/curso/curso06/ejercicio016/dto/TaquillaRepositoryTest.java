package es.cic.curso.curso06.ejercicio016.dto;

import static org.junit.Assert.*;

import java.util.List;

//import static es.cic.curso.curso05.ejercicio013.TaquillaTYestHelper.*;
import org.junit.Before;
import org.junit.Test;

import es.cic.curso.curso06.ejercicio016.dto.Sala;
import es.cic.curso.curso06.ejercicio016.repository.TaquillaRepository;
import es.cic.curso.curso06.ejercicio016.repository.TaquillaRepositoryImpl;

public class TaquillaRepositoryTest {
	private TaquillaRepository sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new TaquillaRepositoryImpl();
	}

	@Test
	public void testVenderEntradas_sala1_sesion1() {
		int numEntradas = 5;
		int numSala = 0;
		int numSesion = 0;
		sut.venderEntradas(numEntradas, numSala, numSesion);
		
		int entradasLibres = sut.verButacasLibres(numSala, numSesion);
		int entradasOcupadas = sut.verButacasOcupadas(numSala, numSesion); 
		
		assertTrue(entradasLibres == 95);
		assertTrue(entradasOcupadas == 5);
	}
	
	@Test
	public void testVenderEntradas_sala2_sesion1() {
		int numEntradas = 5;
		int numSala = 1;
		int numSesion = 0;
		sut.venderEntradas(numEntradas, numSala, numSesion);
		
		int entradasLibres = sut.verButacasLibres(numSala, numSesion);
		int entradasOcupadas = sut.verButacasOcupadas(numSala, numSesion); 
		
		
		assertTrue(entradasLibres == 45);
		assertTrue(entradasOcupadas == 5);
	}
	
	@Test
	public void testVenderEntradas_sala3_sesion1() {
		int numEntradas = 5;
		int numSala = 2;
		int numSesion = 0;
		sut.venderEntradas(numEntradas, numSala, numSesion);
		
		int entradasLibres = sut.verButacasLibres(numSala, numSesion);
		int entradasOcupadas = sut.verButacasOcupadas(numSala, numSesion); 
		
		assertTrue(entradasLibres == 25);
		assertTrue(entradasOcupadas == 5);
		
		int recaudacion = sut.calcularRecaudacion();
		assertTrue(recaudacion == 25);
	}
	
	@Test
	public void testVerRecaudacion() {
		sut.venderEntradas(100, 0, 0);
		sut.venderEntradas(85, 0, 1);
		sut.venderEntradas(98, 0, 2);
		sut.venderEntradas(50, 1, 0);
		sut.venderEntradas(46, 1, 1);
		sut.venderEntradas(35, 1, 2);
		sut.venderEntradas(26, 2, 0);
		sut.venderEntradas(28, 2, 1);
		sut.venderEntradas(30, 2, 2);
		
		int recaudacion = sut.calcularRecaudacion();
		assertTrue(recaudacion == 2490);
	}
	

	@Test
	public void testListar() {
		sut.venderEntradas(100, 0, 0);
		sut.venderEntradas(85, 0, 1);
		sut.venderEntradas(98, 0, 2);
		sut.venderEntradas(50, 1, 0);
		sut.venderEntradas(46, 1, 1);
		sut.venderEntradas(35, 1, 2);
		sut.venderEntradas(26, 2, 0);
		sut.venderEntradas(28, 2, 1);
		sut.venderEntradas(30, 2, 2);
		
		List<Sala>salas = sut.listar();
		
		int ocupadasSala1Sesion1 = salas.get(0).getSesiones().get(0).getButacasOcupadas();
		int ocupadasSala1Sesion2 = salas.get(0).getSesiones().get(1).getButacasOcupadas();
		int ocupadasSala1Sesion3 = salas.get(0).getSesiones().get(2).getButacasOcupadas();
		
		assertTrue(ocupadasSala1Sesion1 == 100);
		assertTrue(ocupadasSala1Sesion2 == 85);
		assertTrue(ocupadasSala1Sesion3 == 98);
		
		int ocupadasSala2Sesion1 = salas.get(1).getSesiones().get(0).getButacasOcupadas();
		int ocupadasSala2Sesion2 = salas.get(1).getSesiones().get(1).getButacasOcupadas();
		int ocupadasSala2Sesion3 = salas.get(1).getSesiones().get(2).getButacasOcupadas();
		
		assertTrue(ocupadasSala2Sesion1 == 50);
		assertTrue(ocupadasSala2Sesion2 == 46);
		assertTrue(ocupadasSala2Sesion3 == 35);
		
		int ocupadasSala3Sesion1 = salas.get(2).getSesiones().get(0).getButacasOcupadas();
		int ocupadasSala3Sesion2 = salas.get(2).getSesiones().get(1).getButacasOcupadas();
		int ocupadasSala3Sesion3 = salas.get(2).getSesiones().get(2).getButacasOcupadas();
		
		assertTrue(ocupadasSala3Sesion1 == 26);
		assertTrue(ocupadasSala3Sesion2 == 28);
		assertTrue(ocupadasSala3Sesion3 == 30);
	}
	
}
