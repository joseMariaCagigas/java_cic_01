package es.cic.curso15.ejercicio016;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso15.ejercicio016.Cine;
import es.cic.curso15.ejercicio016.GestionCineService;
import es.cic.curso15.ejercicio016.SalaCine;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ejercicio016XML.xml")
public class GestionCineServiceTest {

	@Autowired
	private GestionCineService cut;
	
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void testCrearSala(){
		SalaCine s = cut.crearSala();
		int res = s.getSesion().size();
		
		//assertEquals(3,res);
	}
	
	@Test
	public void testCrearCine(){
		Cine c =cut.crearCine();
		int res = c.getSalas().size();
		int res2 =c.getSalas().get(1).getSesion().size();
		
		//assertEquals(3,res);
		//assertEquals(3,res2);
	}
	
	@Test
	public void testGenerarAforo(){
		Cine c=cut.generarAforo();
		
		int res = c.getSalas().get(0).getAforo();
		int res2 = c.getSalas().get(1).getAforo();
		
		assertEquals(100,res);
		assertEquals(50,res2);
	}
	
	@Test
	public void testVentaPosible(){
		boolean venta = cut.compruebaVenta(10, 2, 1);
		
		assertTrue(venta);
		
	}
	
	@Test
	public void testVentaImposible(){
		boolean venta = cut.compruebaVenta(150, 1, 3);
		
		assertFalse(venta);
	}
}