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

import es.cic.curso.curso06.ejercicio016.domain.Sala;
import es.cic.curso.curso06.ejercicio016.repository.RepositorySalaImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:es/cic/curso/curso06/ejercicio016/applicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,TransactionalTestExecutionListener.class})
@Transactional
public class RepositorySalaImplTest {
	
	public static final int capacidad = 50;
	
	@Autowired
	private RepositorySalaImpl sut;
	
	@PersistenceContext
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testInyeccionDependencias() {
		assertNotNull(sut);
		assertNotNull(sut.getRepositorioSala());

	}

	@Test
	public void testCrear() {
		Sala sala = new Sala();
		sala.setCapacidad(30);
		assertNull(sala.getId());
				
		sut.crear(sala);
		
		assertNotNull(sala.getId());
	}
	
	@Test
	public void testLeer(){

		Long clavePrimaria = generaSalaLectura();
		
		Sala resultado = sut.leer(clavePrimaria); 
		
		assertNotEquals(30,  resultado.getCapacidad());
	}
	
	@Test(expected=PersistenceException.class)
	public void testRead_NoExiste() {
		
		Long clavePrimaria = Long.MIN_VALUE;
		
		Sala resultado = sut.leer(clavePrimaria);
		
		assertEquals(30,  resultado.getCapacidad());
	}
	
	@Test
	public void testList() {
		generaSalaLectura();
		generaSalaLectura();
		generaSalaLectura();
		
		List<Sala> resultado = sut.list();
		
		assertTrue(resultado.size() >= 3);
	}
	
	
	
	@Test
	public void testUpdate(){
		Long clavePrimaria = generaSalaLectura();
		
		Sala sala2 = new Sala();
		sala2.setId(clavePrimaria);
		sala2.setCapacidad(60);
		
		Sala resultado = sut.actualizar(sala2);
		
		Sala enBBDD = em.find(Sala.class, clavePrimaria);
		assertEquals(100, enBBDD.getCapacidad());
		assertEquals(30, resultado.getCapacidad());
	}
	
	@Test
	public void testDelete(){
		Long clavePrimaria = generaSalaLectura();
		
		sut.borrar(clavePrimaria);
		
		Sala c;
		try{
			c = em.find(Sala.class, clavePrimaria);
		} catch (PersistenceException pe) {
			return;
		}
		assertNull(c);
		}
	

	private Long generaSalaLectura() {
		Sala sala = new Sala();
		sala.setCapacidad(50);
		sut.crear(sala);
		
		return sala.getId();
	}
}