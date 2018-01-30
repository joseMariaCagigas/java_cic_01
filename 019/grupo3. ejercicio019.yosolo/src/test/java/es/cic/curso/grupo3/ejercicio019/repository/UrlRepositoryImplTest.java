package es.cic.curso.grupo3.ejercicio019.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso.grupo3.ejercicio019.datos.Url;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo3/ejercicio019/applicationContext.xml"
				})
public class UrlRepositoryImplTest extends AbstractRepositoryImplTest<Long, Url> {

	@Autowired
	private UrlRepository sut;
	
	@Before
	public void setUp() throws Exception {
	}

	@Override
	public IRepository<Long, Url> getRepository() {
		return (IRepository<Long, Url>) sut;
	}



	@Override
	public Url getInstanceDeTParaNuevo() {
		Url url = new Url();
		url.setTexto("url1");
		return url;
	}

	@Override
	public Url getInstanceDeTParaLectura() {
		Url url = new Url();
		url.setTexto("url2");
		return url;
	}

	@Override
	public boolean sonDatosIguales(Url t1, Url t2) {
		if (t1 == null || t2 == null) {
			throw new UnsupportedOperationException("No puedo comparar nulos");
		}
		
		if (t1.getTexto() != t2.getTexto()) {
			return false;
		}
		
		return true;
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MIN_VALUE;
	}

	@Override
	public Url getInstanceDeTParaModificar(Long clave) {
		Url url = getInstanceDeTParaLectura();
		url.setId(2L);
		return url;
	}





}
