package es.cic.curso.curso05.ejercicio017;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class FigurasServiceImplTest {
	
	@Autowired
	private FiguraService sut;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testListar() {
		List<Figura> figuras = sut.listar();
		assertTrue(figuras.size() == 0);
		
		Figura figura = new Figura();
		Figura figura2 = new Figura();

		
		
		sut.anadir(figura);

		figuras = sut.listar();
		assertTrue(figuras.size() == 1);
		
		sut.anadir(figura2);
		
		figuras = sut.listar();
		assertTrue(figuras.size() == 2);
		
		sut.borrar(figura2);
		
		figuras = sut.listar();
		assertTrue(figuras.size() == 1);
	}
	
}