package es.cic.curso.curso00.ejercicio015;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaSpringTest {

	private ApplicationContext applicationContext;
	
	
	@Before
	public void setUp() throws Exception {
		applicationContext = 
				new ClassPathXmlApplicationContext("es/cic/curso/curso00/ejercicio015/applicationContextLos.xml");
	}

	@Test
	public void test() {
		CineGestion primario = applicationContext.getBean("cineGestion", CineGestion.class);
		
		assertNotNull(primario);
		
		assertNotNull(primario.getDependencia());
		
		CineFichero secundario = applicationContext.getBean("otro", CineFichero.class);
		
		assertNotNull(secundario);
	}

}
