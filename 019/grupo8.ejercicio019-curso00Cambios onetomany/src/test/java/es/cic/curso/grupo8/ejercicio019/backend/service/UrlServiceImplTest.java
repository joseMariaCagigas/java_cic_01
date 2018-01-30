package es.cic.curso.grupo8.ejercicio019.backend.service;

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

import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.Url;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.UrlRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo8/ejercicio019/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class UrlServiceImplTest {

	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	UrlService sut;
	
	@Autowired
	UrlRepository urlRepository;
	
	@Before
	public void setUp() throws Exception {
		
		limpiarUrl();
	}

	@Test
	public void testAniadirUrl() {
		Long idUrl = sut.aniadirUrl("https://www.google.com");
		
		assertNotNull(idUrl);
	}

	@Test
	public void testActualizarUrl() {
		Long idUrl = sut.aniadirUrl("https://www.google.com");
		
		Url url = sut.obtenerUrl(idUrl);
		url.setEnlace("https://www.yahoo.com");
		
		Url urlMod = sut.obtenerUrl(idUrl);
		assertTrue("https://www.yahoo.com".equals(urlMod.getEnlace()));
	}

	@Test
	public void testBorrarUrl() {
		Long idUrl = sut.aniadirUrl("https://www.google.com");
		
		sut.borrarUrl(idUrl);
		
		List<Url>urls = sut.obtenerUrls();
		
		assertTrue(urls.size() == 0);
	}
	
	private void limpiarUrl(){
		List<Url>urls = sut.obtenerUrls();
		for(Url url : urls){
			urlRepository.delete(url);
		}
	}

}
