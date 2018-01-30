package es.cic.curso.grupo3.ejercicio019.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso.grupo3.ejercicio019.datos.Usuario;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo3/ejercicio019/applicationContext.xml"
				})
public class UsuarioRepositoryImplTest extends AbstractRepositoryImplTest<Long, Usuario> {

	@Autowired
	private UsuarioRepository sut;
	
	@Before
	public void setUp() throws Exception {
	}

	@Override
	public IRepository<Long, Usuario> getRepository() {
		return sut;
	}

	@Override
	public Usuario getInstanceDeTParaNuevo() {
		Usuario usuario = new Usuario();
		usuario.setNombre("pepe");
		usuario.setPassword("pepe123");
		return usuario;
	}

	@Override
	public Usuario getInstanceDeTParaLectura() {
		Usuario usuario = new Usuario();
		usuario.setNombre("juan");
		usuario.setPassword("juan123");
		return usuario;
	}

	@Override
	public boolean sonDatosIguales(Usuario t1, Usuario t2) {
		if (t1 == null || t2 == null) {
			throw new UnsupportedOperationException("No puedo comparar nulos");
		}
		
		if (t1.getNombre() != t2.getNombre()) {
			return false;
		}
		if (t1.getPassword() != t2.getPassword()) {
			return false;
		}		
		
		return true;
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MIN_VALUE;
	}

	@Override
	public Usuario getInstanceDeTParaModificar(Long clave) {
		Usuario usuario = getInstanceDeTParaLectura();
		usuario.setId(2L);
		return usuario;
	}


}
