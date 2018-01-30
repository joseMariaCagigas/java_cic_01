package es.cic.curso.curso06.ejercicio013;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GestionCineTest {

	private GestionCine sut;
	
	@Before
	public void setUp() throws Exception {
		
		sut = new GestionCine();
		sut.venderEntradas(20, 1, 2);
		System.out.println("coste de 20 entradas: ");
		System.out.println(sut.costevenderEntradas(20, 1, 2));
		sut.venderEntradas(30, 2, 1);
		System.out.println("Cantidad de butacas sala 1: " + sut.getSalas().get(0).getButacasTotales());
		System.out.println("Cantidad de butacas sala 1: " + sut.getSalas().get(0).getSesiones().get(1).getButacasDisp());
		System.out.println("Se vendieron: " + sut.totalEntradasVendidas());
		sut.devolverEntradas(300, 2, 1);
		System.out.println("Se vendieron: " + sut.totalEntradasVendidas());
		sut.cierreSala(1);
		System.out.println("Cantidad de butacas  disponibles sala 1 en sesion 1: " + sut.getSalas().get(0).getSesiones().get(1).getButacasDisp());
		sut.abrirSala(1);
		System.out.println("Cantidad de butacas  disponibles sala 1 en sesion 1: " + sut.getSalas().get(0).getSesiones().get(1).getButacasDisp());
	}

	@Test
	public void testvenderentradas() {

		int ent = sut.totalEntradasVendidas();
		assertNotNull(ent);
		
	}
	
	@Test
	public void totalEntradasVendidas() {

		int ent = sut.totalEntradasVendidas();
		assertNotNull(ent);
		
	}

}
