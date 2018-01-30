package es.cic.curso.grupo8.ejercicio019.backend.dominio.nota;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso.grupo8.ejercicio019.backend.AbstractRepositoryImplTest;
import es.cic.curso.grupo8.ejercicio019.backend.IRepository;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.nota.Nota;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.nota.NotaRepository;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.Url;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo8/ejercicio019/applicationContext.xml"
		})
public class NotaRepositoryTest extends AbstractRepositoryImplTest<Long, Nota>{

	
	@Autowired
	private NotaRepository sut;

	private Usuario usuario;
	private Url url;

	
	@Override
	public IRepository<Long, Nota> getRepository() {
		
		return sut;
	}

	@Override
	@Before
	public void setUp() {
		super.setUp();
		
		usuario = new Usuario("Aitor", "Aitor", "Inventado");
		em.persist(usuario);
		
		url = new Url();
		url.setEnlace("https://www.google.com/");
		em.persist(url);
	}

	
	@Override
	public Nota getInstanceDeTParaNuevo() {
		
		Nota notaTest = new Nota();
		notaTest.setUsuario(usuario);
		notaTest.setUrl(url);
		notaTest.setContenido("Nota de prueba Numero 1.");
		notaTest.setEstaHecho(false);
		return notaTest;
	}

	@Override
	public Nota getInstanceDeTParaLectura() {
		
		Nota notaTest = new Nota();
		notaTest.setUsuario(usuario);
		notaTest.setUrl(url);
		notaTest.setContenido("Nota de prueba Numero 1.");
		notaTest.setEstaHecho(false);
		return notaTest;
	}

	@Override
	public boolean sonDatosIguales(Nota t1, Nota t2) {
		
		if (t1 == null || t2 == null) {
			throw new UnsupportedOperationException("No puedo comparar nulos");
		}
		if (!t1.getUsuario().equals(t2.getUsuario())) {
			return false;
		}
		if (!t1.getUrl().equals(t2.getUrl())) {
			return false;
		}		
		if (!t1.getContenido().equals(t2.getContenido())) {
			return false;
		}
		if (t1.isEstaHecho() != t2.isEstaHecho()) {
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
		
		Nota notaTest = getInstanceDeTParaLectura();
		notaTest.setId(clave);
		notaTest.setContenido("Texto modificado");
		return notaTest;
	}


}
