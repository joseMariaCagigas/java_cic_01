package es.cic.curso.curso05.ejercicio014.service;

import static org.junit.Assert.*;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import es.cic.curso.curso05.ejercicio014.service.NoHayUnidadesSuficientesException;
import es.cic.curso.curso05.ejercicio014.dominio.producto.Producto;
import es.cic.curso.curso05.ejercicio014.dominio.producto.ProductoRepository;
import es.cic.curso.curso05.ejercicio014.dominio.venta.Venta;
import es.cic.curso.curso05.ejercicio014.dominio.venta.VentaRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/curso05/ejercicio014/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class TiendaServiceImplTest {

	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	TiendaService sut;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	VentaRepository ventaRepository;
	
	@Before
	public void setUp() throws Exception {
		limpiarInventario();
		limpiarVentas();
		
	}

	
	@Test
	public void testObtenerUdsProducto(){
		
		Long idCafe = sut.aniadirProducto(1, "cafe", 4, 14, 10);
		Long idLeche = sut.aniadirProducto(2, "leche", 1, 34, 56);
		Long idGalletas = sut.aniadirProducto(3, "galletas", 2, 15 ,25);
		
		int udsCafe = sut.obtenerUdsProducto(idCafe);
		int udsLeche = sut.obtenerUdsProducto(idLeche);
		int udsGalletas = sut.obtenerUdsProducto(idGalletas);
		
		assertTrue(udsCafe == 24);
		assertTrue(udsLeche == 90);
		assertTrue(udsGalletas == 40);

			

	}
	
	@Test
	public void testVender_si() throws NoHayUnidadesSuficientesException{

		Long idCafe = sut.aniadirProducto(1, "cafe", 4, 14, 10);
		Long idLeche = sut.aniadirProducto(2, "leche", 1, 34, 56);
		Long idGalletas = sut.aniadirProducto(3, "galletas", 2, 15 ,25);
		
		Long idVentaCafe = sut.vender(idCafe, 10);
		Long idVentaLeche = sut.vender(idLeche, 90);
		Long idVentaGalletas = sut.vender(idGalletas, 30);
		
		assertNotNull(idVentaCafe);
		assertNotNull(idVentaLeche);
		assertNotNull(idVentaGalletas);
		
		int udsCafe = sut.obtenerUdsProducto(idCafe);
		int udsLeche = sut.obtenerUdsProducto(idLeche);
		int udsGalletas = sut.obtenerUdsProducto(idGalletas);
		
		assertTrue(udsCafe == 14);
		assertTrue(udsLeche == 0);
		assertTrue(udsGalletas == 10);
	}
	
	@Test(expected= NoHayUnidadesSuficientesException.class)
	public void testVender_no() throws NoHayUnidadesSuficientesException{

		Long idCafe = sut.aniadirProducto(1, "cafe", 4, 14, 10);
		
		Long idVentaCafe = sut.vender(idCafe, 25);
		
		
	}
	
	@Test
	public void testListarProductos(){

		Long idCafe = sut.aniadirProducto(1, "cafe", 4, 14, 10);
		Long idLeche = sut.aniadirProducto(2, "leche", 1, 34, 56);
		Long idGalletas = sut.aniadirProducto(3, "galletas", 2, 15 ,25);
		
		List<Producto>productos = sut.obtenerProductos();
		
		assertTrue(productos.size() == 3);
	}
	
	@Test
	public void testListarVentas() throws NoHayUnidadesSuficientesException{

		Long idCafe = sut.aniadirProducto(1, "cafe", 4, 14, 10);
		Long idLeche = sut.aniadirProducto(2, "leche", 1, 34, 56);
		Long idGalletas = sut.aniadirProducto(3, "galletas", 2, 15 ,25);
		
		Long idVentaCafe = sut.vender(idCafe, 10);
		Long idVentaLeche = sut.vender(idLeche, 90);
		Long idVentaGalletas = sut.vender(idGalletas, 30);
		
		List<Venta>ventas = sut.obtenerVentas();
		
		assertTrue(ventas.size() == 3);
	}
	
	@Test
	public void testHayProducto_si(){
		

		Long idCafe = sut.aniadirProducto(1, "cafe", 4, 14, 10);
		
		boolean hayProducto = sut.hayProducto(idCafe, 24);
		
		assertTrue(hayProducto == true);
		
	}
	
	@Test
	public void testHayProducto_no(){
		

		Long idCafe = sut.aniadirProducto(1, "cafe", 4, 14, 10);
		
		boolean hayProducto = sut.hayProducto(idCafe, 25);
		
		assertTrue(hayProducto == false);
		
	}

	private void limpiarInventario() {
		List<Producto> listaProductos = productoRepository.list();
		for (Producto producto: listaProductos) {
			productoRepository.delete(producto);
		}
	}
	
	private void limpiarVentas() {
		List<Venta> listaVenta = ventaRepository.list();
		for (Venta proventa: listaVenta) {
			ventaRepository.delete(proventa);
		}
	}
	
}
