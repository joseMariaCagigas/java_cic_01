package es.cic.curso.curso17.ejercicio016.repository;

import static org.junit.Assert.*;

import org.junit.Test;

import es.cic.curso.curso17.ejercicio016.SesionImpl;
import es.cic.curso.curso17.ejercicio016.SesionInterface;

/**
 * Pruebas sobre la clase <code>Sesion</code>.
 * 
 * 
 * @author J. Francisco Martín
 * @version 20170113
 *
 */
public class SesionTestRepository {

	public static final int SIZE = 100;

	@Test
	public void testCapacidad() {
		SesionInterface sut;

		sut = new SesionImpl(0);
		assertEquals(0, sut.capacidad());

		sut = new SesionImpl(SIZE);
		assertEquals(100, sut.capacidad());
	}

	@Test
	public void testCambiarDisponibilidad() {
		SesionInterface sut = new SesionImpl(SIZE);

		sut.cambiaDisponibilidad(0, true);
		assertTrue(sut.estaDisponible(0));
		assertTrue(sut.estaDisponible(SIZE / 2));
		assertTrue(sut.estaDisponible(SIZE - 1));

		sut.cambiaDisponibilidad(0, false);
		assertFalse(sut.estaDisponible(0));
		assertTrue(sut.estaDisponible(SIZE / 2));
		assertTrue(sut.estaDisponible(SIZE - 1));

		sut.cambiaDisponibilidad(0, false);
		sut.cambiaDisponibilidad((SIZE / 2), false);
		sut.cambiaDisponibilidad((SIZE - 1), false);
		assertFalse(sut.estaDisponible(0));
		assertFalse(sut.estaDisponible(SIZE / 2));
		assertFalse(sut.estaDisponible(SIZE - 1));

		sut.cambiaDisponibilidad(0, true);
		sut.cambiaDisponibilidad((SIZE / 2), true);
		sut.cambiaDisponibilidad((SIZE - 1), true);
		assertTrue(sut.estaDisponible(0));
		assertTrue(sut.estaDisponible(SIZE / 2));
		assertTrue(sut.estaDisponible(SIZE - 1));
	}

	@Test
	public void testLocalidadesDisponibles() {
		SesionInterface sut = new SesionImpl(SIZE);
		assertEquals(SIZE, sut.localidadesDisponibles());
		assertEquals(0, sut.localidadesOcupadas());

		sut.cambiaDisponibilidad(0, false);
		assertEquals(SIZE - 1, sut.localidadesDisponibles());
		assertEquals(1, sut.localidadesOcupadas());
	}

	@Test
	public void testOcuparLocalidadDisponible() {
		SesionInterface sut = new SesionImpl(SIZE);

		assertEquals(SIZE, sut.localidadesDisponibles());
		sut.ocupaLocalidadDisponible();
		assertEquals((SIZE - 1), sut.localidadesDisponibles());

		for (int i = 1; i < SIZE - 1; i++) {
			sut.ocupaLocalidadDisponible();
		}
		assertEquals((SIZE - 1), sut.localidadesOcupadas());
	}

}
