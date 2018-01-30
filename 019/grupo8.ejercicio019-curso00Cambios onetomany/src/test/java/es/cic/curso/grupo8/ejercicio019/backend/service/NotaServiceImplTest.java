package es.cic.curso.grupo8.ejercicio019.backend.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

import es.cic.curso.grupo8.ejercicio019.backend.dominio.nota.Nota;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.nota.NotaRepository;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.Usuario;
import es.cic.curso.grupo8.ejercicio019.backend.service.NotaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo8/ejercicio019/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class NotaServiceImplTest {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	NotaService sut;
	
	@Autowired
	NotaRepository notaRepository;
	
	private Usuario usuario1;
	private Usuario usuario2;	
	private Usuario usuario3;
	
	@Before
	public void setUp() throws Exception {
		
		limpiarNotas();
		
		usuario1 = new Usuario("Aitor", "Aitor", "Inventado");
		entityManager.persist(usuario1);	
		
		usuario2 = new Usuario("Lorena", "Lorena", "Inventado");
		entityManager.persist(usuario2);		
	
		usuario3 = new Usuario("Tedi", "Tedi", "Inventado");
		entityManager.persist(usuario3);		
	}

	@Test
	public void testAniadirNota() {
		
		Long idNota1 = sut.aniadirNota(usuario1.getId(), "Nota de prueba 1");
		
		assertNotNull(idNota1);
	}

	@Test
	public void testObtenerNota() {
		
		Long idNota1 = sut.aniadirNota(usuario1.getId(), "Nota de prueba 1");
		
		Nota notaObtenida = sut.obtenerNota(idNota1);
		
		assertNotNull(notaObtenida.getId());
		assertTrue("Nota de prueba 1".equals(notaObtenida.getContenido()));
	}

	@Test
	public void testObtenerNotas() {
		
		List<Nota>listaNotas = sut.obtenerNotas();
		
		for(Nota nota : listaNotas){
			
			assertNotNull(nota.getId());
		}
	}

	@Test
	public void testObtenerNotasUsuario() {
		
		sut.aniadirNota(usuario1.getId(), "Nota de prueba 1");
		sut.aniadirNota(usuario2.getId(), "Nota de prueba 2");
		sut.aniadirNota(usuario3.getId(), "Nota de prueba 3");
		sut.aniadirNota(usuario1.getId(), "Nota de prueba 4");
		sut.aniadirNota(usuario1.getId(), "Nota de prueba 5");
		sut.aniadirNota(usuario3.getId(), "Nota de prueba 6");
		
		assertEquals(3, sut.obtenerNotasUsuario(usuario1.getId()).size());
		assertEquals(1, sut.obtenerNotasUsuario(usuario2.getId()).size());
		assertEquals(2, sut.obtenerNotasUsuario(usuario3.getId()).size());
	}
	
	@Test
	public void testActualizarNota() {
		
		Long idNota1 = sut.aniadirNota(usuario1.getId(), "Nota de prueba 1");
		
		Nota notaActualizable = sut.obtenerNota(idNota1);
		notaActualizable.setContenido("Nota de prueba 1 - modificada");
		
		Nota notaModelo = sut.obtenerNota(idNota1);
		assertTrue("Nota de prueba 1 - modificada".equals(notaModelo.getContenido()));
	}

	@Test
	public void testBorrarNota() {
		
		Long idNota1 = sut.aniadirNota(usuario1.getId(), "Nota de prueba 1");
		
		sut.borrarNota(idNota1);
		
		List<Nota>listaNotas = sut.obtenerNotas();
		
		assertTrue(listaNotas.size() == 0);
	}

	private void limpiarNotas() {
		
		List<Nota>listaNotas = sut.obtenerNotas();
		
		for(Nota nota : listaNotas){
			
			notaRepository.delete(nota);
		}
	}
}
