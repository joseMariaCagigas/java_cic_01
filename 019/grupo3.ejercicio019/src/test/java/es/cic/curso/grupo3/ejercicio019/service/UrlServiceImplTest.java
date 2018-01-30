package es.cic.curso.grupo3.ejercicio019.service;

import static org.junit.Assert.*;

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

import es.cic.curso.grupo3.ejercicio019.datos.Url;
import es.cic.curso.grupo3.ejercicio019.repository.UrlRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo3/ejercicio019/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class UrlServiceImplTest {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UrlService urlService;
	@Autowired
	private UrlRepository urlRepository;
	
	Long claveUrl;
	Url url;

	@Before
	public void setUp() throws Exception {
		claveUrl = generaUrl();
		url = urlRepository.read(claveUrl);
	}

	@Test
	public void testNueva() {
		Url resultado = urlService.nueva("Bien");
		
		urlRepository.add(resultado);
		
		assertEquals("Bien", resultado.getTexto());
	}

	@Test
	public void testModificar() {
		boolean resultado = urlService.modificar(url, "Sobresaliente");
		
		assertEquals(true, resultado);
		assertEquals("Sobresaliente", url.getTexto());
	}

	@Test
	public void testBorrar() {
		boolean resultado = urlService.borrar(url);
		
		assertEquals(true, resultado);
	}
	
	public Long generaUrl() {
		Url u = new Url();
		u.setTexto("Notable");;
		
		em.persist(u);
		return u.getId();
	}
}