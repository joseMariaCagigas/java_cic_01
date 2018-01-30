package es.cic.curso.grupo8.ejercicio019.backend.dominio.url;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso.grupo8.ejercicio019.backend.AbstractRepositoryImplTest;
import es.cic.curso.grupo8.ejercicio019.backend.IRepository;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.Url;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.UrlRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo8/ejercicio019/applicationContext.xml"
		})
public class UrlRepositoryTest extends AbstractRepositoryImplTest<Long, Url>{

	@Autowired
	private UrlRepository sut;

	@Override
	public IRepository<Long, Url> getRepository() {
		
		return sut;
	}

	@Override
	public Url getInstanceDeTParaNuevo() {
		
		Url urlTest = new Url();
		urlTest.setEnlace("http://www.google.com");
		return urlTest;
	}

	@Override
	public Url getInstanceDeTParaLectura() {
		
		Url urlTest = new Url();
		urlTest.setEnlace("http://www.google.com");
		return urlTest;
	}

	@Override
	public boolean sonDatosIguales(Url t1, Url t2) {
		
		if (t1 == null || t2 == null) {
			throw new UnsupportedOperationException("No puedo comparar nulos");
		}
		if (t1.getEnlace() != t2.getEnlace()) {
			return false;
		}
		
		return true;
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		
		return Long.MAX_VALUE;
	}

	@Override
	public Url getInstanceDeTParaModificar(Long clave) {
		
		Url urlTest = getInstanceDeTParaLectura();
		urlTest.setId(clave);
		urlTest.setEnlace("http://www.yahoo.com");
		return urlTest;
	}




}
