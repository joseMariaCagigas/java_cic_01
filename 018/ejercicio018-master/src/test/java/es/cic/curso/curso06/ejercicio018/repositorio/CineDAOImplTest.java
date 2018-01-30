package es.cic.curso.curso06.ejercicio018.repositorio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.curso06.ejercicio018.dominio.Cine;
import es.cic.curso.curso06.ejercicio018.repositorio.CineDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/curso06/ejercicio018/repositorio/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class CineDAOImplTest {

	@Autowired
	private CineDAO cineDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCrea() {
		Cine cine = new Cine();
		cine.setNombre("Mi cine");
		assertNull(cine.getId());
		
		
		cineDAO.crea(cine);
		
		assertNotNull(cine.getId());
	}

}
