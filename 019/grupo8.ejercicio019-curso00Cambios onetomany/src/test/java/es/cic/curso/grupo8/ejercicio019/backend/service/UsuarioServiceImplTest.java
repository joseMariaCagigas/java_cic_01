package es.cic.curso.grupo8.ejercicio019.backend.service;

import static org.junit.Assert.*;

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

import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.Usuario;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.UsuarioRepository;
import es.cic.curso.grupo8.ejercicio019.backend.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo8/ejercicio019/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class UsuarioServiceImplTest {

	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	UsuarioService sut;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Before
	public void setUp() throws Exception {
		limpiarUsuarios();
	}

	@Test
	public void testAniadirUsuario() {
		Long idUsuario1 = sut.aniadirUsuario("Pablo", "pablomirlo", "Vega Pérez");
		
		assertNotNull(idUsuario1);
	}

	@Test
	public void testObtenerUsuario() {
		Long idUsuario1 = sut.aniadirUsuario("Pablo", "pablomirlo", "Vega Pérez");
		
		Usuario usuario = sut.obtenerUsuario(idUsuario1);
		
		assertNotNull(usuario.getId());
		assertTrue("Pablo".equals(usuario.getNombre()));
	}

	@Test
	public void testObtenerUsuarios() {
		List<Usuario>usuarios = sut.obtenerUsuarios();
		for(Usuario usuario : usuarios){
			assertNotNull(usuario.getId());
		}
	}

	@Test
	public void testActualizarUsuario() {
		Long idUsuario1 = sut.aniadirUsuario("Pablo", "pablomirlo", "Vega Pérez");
		
		Usuario usuario = sut.obtenerUsuario(idUsuario1);
		usuario.setNombre("Aitor");
		
		Usuario usuarioMod = sut.obtenerUsuario(idUsuario1);
		assertTrue("Aitor".equals(usuarioMod.getNombre()));
	}

	@Test
	public void testBorrarUsuario() {
		Long idUsuario1 = sut.aniadirUsuario("Pablo", "pablomirlo", "Vega Pérez");
		
		sut.borrarUsuario(idUsuario1);
		
		List<Usuario>usuarios = sut.obtenerUsuarios();
		
		assertTrue(usuarios.size() == 0);
	}

	private void limpiarUsuarios(){
		List<Usuario>usuarios = sut.obtenerUsuarios();
		for(Usuario usuario : usuarios){
			usuarioRepository.delete(usuario);
		}
	}
	
	
}
