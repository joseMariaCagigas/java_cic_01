package es.cic.curso.curso00.ejercicio014;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InventarioFicheroTest {

	private InventarioFichero sut;
	
	@Before
	public void setup() {
		sut = new InventarioFichero();
	}
	
	@Test
	public void testCargar() throws FileNotFoundException, IOException {
		List<Inventario> resultado = sut.cargar();
		assertEquals(4, resultado.size());
	}
	
	@Test
	public void testCuantosDisponibles() throws FileNotFoundException, IOException {
		List<Inventario> listaInventario = sut.cargar();

		int cuantosDeCafe = sut.cuantosDisponibles(InventarioFichero.CAFE, listaInventario);
	
		assertEquals(5, cuantosDeCafe);
	}
	
	@Test
	public void testHayDisponibles() throws FileNotFoundException, IOException {
		List<Inventario> listaInventario = sut.cargar();

		boolean resultado = sut.hayDisponibles(InventarioFichero.CAFE, 4, listaInventario);
	
		assertTrue(resultado);
	}
	
	@Test
	public void testHayDisponibles_No() throws FileNotFoundException, IOException {
		List<Inventario> listaInventario = sut.cargar();

		boolean resultado = sut.hayDisponibles(InventarioFichero.CAFE, 6, listaInventario);
	
		assertFalse(resultado);
	}	
	
	@Test
	public void testCalcularPrecio() throws FileNotFoundException, IOException {
		List<Inventario> listaInventario = sut.cargar();

		int resultado = sut.calcularPrecio(InventarioFichero.CAFE);
	
		assertEquals(4, resultado);
	}	
	
	@Test
	public void testCalcularPrecio_Varios() throws FileNotFoundException, IOException {
		List<Inventario> listaInventario = sut.cargar();

		int resultado = sut.calcularPrecio(InventarioFichero.LECHE, 3);
	
		assertEquals(3, resultado);
	}
	
	@Test
	public void testVender() throws FileNotFoundException, IOException {
		List<Inventario> listaInventario = sut.cargar();

		
		
		sut.vender(InventarioFichero.CAFE, 4, listaInventario);
	
		int cuantosDeCafe = sut.cuantosDisponibles(InventarioFichero.CAFE, listaInventario);
		assertEquals(1, cuantosDeCafe);
		
		assertEquals(1, listaInventario.get(0).getCantidad());
	}	
	
	@Test
	public void testCompleto() throws FileNotFoundException, IOException {
		
		List<Inventario> listaInventario = sut.cargar();

		boolean resultado = sut.hayDisponibles(InventarioFichero.CAFE, 4, listaInventario);
		assertTrue(resultado);	
		
		int precio = sut.calcularPrecio(InventarioFichero.CAFE, 4);
		
		assertEquals(16, precio);
		
		
		sut.vender(InventarioFichero.CAFE, 4, listaInventario);

		int cuantosDeCafe = sut.cuantosDisponibles(InventarioFichero.CAFE, listaInventario);
		assertEquals(1, cuantosDeCafe);

		
		assertEquals(1, listaInventario.get(0).getCantidad());
	}	
}
