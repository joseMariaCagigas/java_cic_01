package es.cic.curso.grupo3.ejercicio019.repository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo3.ejercicio019.datos.Nota;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo3/ejercicio019/applicationContext.xml"
				})

public class NotaRepositoryImplTest extends AbstractRepositoryImplTest<Long, Nota> {

	
	@Autowired
	private NotaRepository sut;
	
	@Before
	public void setUp() throws Exception {
	}

	@Override
	public Nota getInstanceDeTParaNuevo() {
		Nota nota = new Nota();
		nota.setUsuarioId(1L);		
		nota.setUrlId(1L);;
		nota.setTexto("texto");
		nota.setCheck(false);
		return nota;
	}

	@Override
	public Nota getInstanceDeTParaLectura() {
		Nota nota = new Nota();
		nota.setUsuarioId(2L);		
		nota.setUrlId(2L);;
		nota.setTexto("texto2");
		nota.setCheck(false);
		return nota;
	}

	@Override
	public boolean sonDatosIguales(Nota t1, Nota t2) {
		if (t1 == null || t2 == null) {
			throw new UnsupportedOperationException("No puedo comparar nulos");
		}
		if (t1.getUsuarioId() != t2.getUsuarioId()) {
			return false;
		}
		
		if (t1.getUrlId()!= t2.getUrlId()) {
			return false;
		}
		if (t1.getTexto()!= t2.getTexto()) {
			return false;
		}
		if (t1.isCheck() && !t2.isCheck() || !t1.isCheck() && t2.isCheck()) {
			return false;
		}	
		
		return true;
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Nota getInstanceDeTParaModificar(Long clave) {
		Nota producto = getInstanceDeTParaLectura();
		producto.setId(clave);
		producto.setTexto("TODO");
		return producto;
	}

	@Override
	public IRepository<Long, Nota> getRepository() {
		return sut;
	}	
}
