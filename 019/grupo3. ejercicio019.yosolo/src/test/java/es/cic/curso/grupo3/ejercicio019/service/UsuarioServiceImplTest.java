package es.cic.curso.grupo3.ejercicio019.service;

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

import es.cic.curso.grupo3.ejercicio019.datos.Nota;
import es.cic.curso.grupo3.ejercicio019.datos.Usuario;
import es.cic.curso.grupo3.ejercicio019.repository.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/grupo3/ejercicio019/applicationContext.xml"
				})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@Transactional
public class UsuarioServiceImplTest {
	private static final double DELTA_CANTIDAD = 0.001;

	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@Autowired
	private UsuarioService sut;
	
	@Before
	public void setUp() throws Exception {
		
		limpiarUsuario();
		inicializaBaseDeDatos();
	}

	@Test
	public void testInsertar() {
		Usuario nuevo = new Usuario();
		nuevo = sut.insertarUsuario("pepe", "pepe123");
		nuevo = usuarioRepository.read(nuevo.getId());
		
		assertEquals("pepe", nuevo.getNombre());
		assertEquals(4, usuarioRepository.list().size());
	}
	

	@Test
	public void testBorrar() {
		
		Usuario borrar = new Usuario();
		borrar = sut.insertarUsuario("aa", "aa123");
		borrar = usuarioRepository.read(borrar.getId());
		
		sut.borrarUsuario(borrar.getId());
		assertEquals(3, usuarioRepository.list().size());
	}
	
	
	
	
	private void inicializaBaseDeDatos() {
		usuario1 = new Usuario("juan","juan123");
		usuario2 = new Usuario("pedro","pedro123");
		usuario3 = new Usuario("abc","abc123");
		
		
		em.persist(usuario1);
		em.persist(usuario2);
		em.persist(usuario3);		
		
		
	}

	private void limpiarUsuario() {
		List<Usuario> listaUsuario = usuarioRepository.list();
		for (Usuario usuario: listaUsuario) {
			usuarioRepository.delete(usuario);
		}
	}

}
