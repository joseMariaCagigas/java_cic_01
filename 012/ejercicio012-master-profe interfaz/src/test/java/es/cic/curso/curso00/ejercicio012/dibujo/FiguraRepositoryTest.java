package es.cic.curso.curso00.ejercicio012.dibujo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FiguraRepositoryTest {

	private FiguraRepositoryImpl sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new FiguraRepositoryImpl();
	}

	@Test
	public void testListar() {
		List<Figura> resultado = sut.listar();
		
		assertNotNull("La lista no puede ser nula", resultado);
	}
	
	@Test
	public void testNuevo() {
		Figura figuraNueva = new Figura();
		
		sut.nuevo(figuraNueva);
		
		List<Figura> lista = sut.listar();
		assertTrue("La figura no se ha añadido", lista.contains(figuraNueva));
	}
	
	@Test
	public void testBorrar() {
		Figura figuraNueva = generaYGuarda(1);
		Figura figuraNueva2 = generaYGuarda(2);
		
		List<Figura> lista = sut.listar();	
		int posicion = lista.indexOf(figuraNueva);
		sut.borrar(posicion);

		assertFalse("La figura no se ha borrado", lista.contains(figuraNueva));
		assertTrue("La figura ha borrado el que no es", lista.contains(figuraNueva2));
	}

	@Test
	public void testGuardarYLeer() throws IOException {
		Figura figuraNueva = generaYGuarda(3);
		Figura figuraNueva2 = generaYGuarda(4);
		
		Path p = Files.createTempFile("figuras", ".txt");
		sut.guardar(p.toString());
		
		List<Figura> lista = sut.listar();	
		int posicion = lista.indexOf(figuraNueva);
		sut.borrar(posicion);
	
		posicion = lista.indexOf(figuraNueva2);
		sut.borrar(posicion);

		
		sut.cargar(p.toString());
				
		
		lista = sut.listar();	
		assertTrue("El repositorio no contiene alguna de la figuras guardadas", lista.contains(figuraNueva));
		assertTrue("El repositorio no contiene alguna de la figuras guardadas", lista.contains(figuraNueva2));
	}	
	
	private Figura generaYGuarda(int color) {
		Figura figuraNueva = new Figura(0, (short)color, (byte)0, new Centro());
		sut.nuevo(figuraNueva);
		return figuraNueva;
	}	
	


}
