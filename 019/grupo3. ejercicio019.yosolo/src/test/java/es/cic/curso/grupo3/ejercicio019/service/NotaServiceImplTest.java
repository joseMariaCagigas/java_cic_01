package es.cic.curso.grupo3.ejercicio019.service;

import static org.junit.Assert.*;

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

import es.cic.curso.grupo3.ejercicio019.datos.Nota;
import es.cic.curso.grupo3.ejercicio019.repository.NotaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo3/ejercicio019/applicationContext.xml"
		})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class NotaServiceImplTest {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private NotaService notaService;
	@Autowired
	private NotaRepository notaRepository;
	
	Long claveNota;
	Nota nota;

	@Before
	public void setUp() throws Exception {
		claveNota = generaNota();
		nota = notaRepository.read(claveNota);
	}

	@Test
	public void testCheck() {
		boolean resultado = notaService.check(nota);
		
		assertEquals(true, resultado);
	}
	
	@Test
	public void testUncheck_Check() {

		assertEquals(false, nota.isCheck());
		
		boolean resultado = notaService.check(nota);
		
		assertEquals(true, resultado);
		assertEquals(true, nota.isCheck());
	}
	
	@Test
	public void testUncheck_Check_Uncheck() {
		assertEquals(false, nota.isCheck());
		
		boolean resultado = notaService.check(nota);
		
		assertEquals(true, resultado);
		assertEquals(true, nota.isCheck());
		
		resultado = notaService.uncheck(nota);
		
		assertEquals(true, resultado);
		assertEquals(false, nota.isCheck());
	}
	
	@Test
	public void testListar() {
		generaNota();
		generaNota();
		generaNota();

		List<Nota> resultado = notaService.listar();
		
		assertTrue(resultado.size() >= 3);
	}
	
	@Test
	public void testInsertar() {
		Nota nueva = new Nota();
		nueva = notaService.insertarNota(1L, 2L, "TODO", true);
		nueva = notaRepository.read(nueva.getId());
		
		
		assertEquals("TODO",nueva.getTexto());
		assertEquals(2,notaRepository.list().size());
		
	}
	
	public Long generaNota() {
		Nota n = new Nota();
		n.setUsuarioId((long)1);
		n.setUrlId((long)1);
		n.setTexto("texto");
		n.setCheck(false);
		
		em.persist(n);
		return n.getId();
	}
}