package es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso.grupo8.ejercicio019.backend.AbstractRepositoryImplTest;
import es.cic.curso.grupo8.ejercicio019.backend.IRepository;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.Usuario;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo8/ejercicio019/applicationContext.xml"
				})
public class UsuarioRepositoryTest extends AbstractRepositoryImplTest<Long, Usuario> {

	@Autowired
	private UsuarioRepository sut;



	@Override
	public IRepository<Long, Usuario> getRepository() {
		return sut;
	}

	@Override
	public Usuario getInstanceDeTParaNuevo() {
		Usuario usuario = new Usuario();
		usuario.setNombre("pablo");
		usuario.setNombreUsuario("pablomirlo");
		usuario.setApellidos("vega perez");
		return usuario;
	}

	@Override
	public Usuario getInstanceDeTParaLectura() {
		Usuario usuario = new Usuario();
		usuario.setNombre("pablo");
		usuario.setNombreUsuario("pablomirlo");
		usuario.setApellidos("vega perez");
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
		
		if (t1.getApellidos() != t2.getApellidos()) {
			return false;
		}
		if (t1.getNombreUsuario() != t2.getNombreUsuario()) {
			return false;
		}		
		return true;
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Usuario getInstanceDeTParaModificar(Long clave) {
		Usuario usuario = getInstanceDeTParaLectura();
		usuario.setId(clave);
		usuario.setNombre("pepe");
		return usuario;
	}

	
}
