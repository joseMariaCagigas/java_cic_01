package es.cic.curso.curso06.ejercicio017;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso.curso06.ejercicio017.Figura;
import es.cic.curso.curso06.ejercicio017.ServiceFigura;
import es.cic.curso.curso06.ejercicio017.Punto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class ServiceFiguraTest {
	
	@Autowired
	private ServiceFigura sut;

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() {
		sut.getFiguraRepository().vaciarLista();
	}

	@Test
	public void testListarFiguras() {
		assertNotNull("La lista no puede ser nula.", sut);
	}
	
	@Test
	public void testAgregarFigura() {
		Figura figura01 = new Figura();
		Figura figura02 = new Figura(255, new Punto(10, 10));
		sut.getFiguraRepository().agregarFigura(figura01);
		sut.getFiguraRepository().agregarFigura(figura02);
		List<Figura> lista = sut.getFiguraRepository().listarFiguras();
		assertEquals("La lista tiene que tener 2 elementos.", 2, lista.size());
	}
	
	@Test
	public void testBorrarFigura() {
		Figura figura01 = new Figura();
		Figura figura02 = new Figura(255, new Punto(10, 10));
		sut.getFiguraRepository().agregarFigura(figura01);
		sut.getFiguraRepository().agregarFigura(figura02);
		List<Figura> lista = sut.getFiguraRepository().listarFiguras();
		int posicion = lista.indexOf(figura01);
		sut.getFiguraRepository().borrarFigura(posicion);
		assertFalse("La lista NO debería contener la figura1", lista.contains(figura01));
		assertTrue("La lista SI debería contener la figura2", lista.contains(figura02));
	}

}
