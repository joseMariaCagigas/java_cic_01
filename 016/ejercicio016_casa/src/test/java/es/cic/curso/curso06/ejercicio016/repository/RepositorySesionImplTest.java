package es.cic.curso.curso06.ejercicio016.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.curso06.ejercicio016.domain.Sesion;
import es.cic.curso.curso06.ejercicio016.repository.RepositorySesionImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/curso06/ejercicio016/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class RepositorySesionImplTest {
	
	public static final int numButacas = 50;
	
	@Autowired
	private RepositorySesionImpl sut;
	
	@PersistenceContext
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testInyeccionDependencias() {
		assertNotNull(sut);
		assertNotNull(sut.getRepositorioSesion());

	}

	@Test
	public void testCrear() {
		Sesion sesion = new Sesion();
		sesion.setNumButacas(numButacas);
		assertNull(sesion.getId());
				
		sut.crear(sesion);
		
		assertNotNull(sesion.getId());
	}
	
	@Test
	public void testLeer(){

		Long clavePrimaria = generaSesionLectura();
		
		Sesion resultado = sut.leer(clavePrimaria); 
		
		assertNotEquals(numButacas,  resultado.getNumButacas());
	}
	
	@Test(expected=PersistenceException.class)
	public void testRead_NoExiste() {
		
		Long clavePrimaria = Long.MIN_VALUE;
		
		Sesion resultado = sut.leer(clavePrimaria);
		
		assertEquals(numButacas,  resultado.getNumButacas());
	}
	
	@Test
	public void testList() {
		generaSesionLectura();
		generaSesionLectura();
		generaSesionLectura();
		
		List<Sesion> resultado = sut.list();
		
		assertTrue(resultado.size() >= 3);
	}
	
	
	
	@Test
	public void testUpdate(){
		Long clavePrimaria = generaSesionLectura();
		
		Sesion sesion2 = new Sesion();
		sesion2.setId(clavePrimaria);
		sesion2.setNumButacas(numButacas);
		
		Sesion resultado = sut.actualizar(sesion2);
		
		Sesion enBBDD = em.find(Sesion.class, clavePrimaria);
		assertEquals(numButacas, enBBDD.getNumButacas());
		assertEquals(numButacas, resultado.getNumButacas());
	}
	
	@Test
	public void testDelete(){
		Long clavePrimaria = generaSesionLectura();
		
		sut.borrar(clavePrimaria);
		
		Sesion c;
		try{
			c = em.find(Sesion.class, clavePrimaria);
		} catch (PersistenceException pe) {
			return;
		}
		assertNull(c);
		}
	

	private Long generaSesionLectura() {
		Sesion sesion = new Sesion();
		sesion.setNumButacas(numButacas);
		sut.crear(sesion);
		
		return sesion.getId();
	}
}