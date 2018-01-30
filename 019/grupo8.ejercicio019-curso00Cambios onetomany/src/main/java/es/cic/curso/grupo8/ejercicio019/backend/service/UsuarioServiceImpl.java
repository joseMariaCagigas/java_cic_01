package es.cic.curso.grupo8.ejercicio019.backend.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.Usuario;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PersistenceContext
	private EntityManager entityMnager;
	
	
	/* (non-Javadoc)
	 * @see es.cic.curso.grupo8.ejercicio019.service.UsuarioService#aniadirUsuario(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Long aniadirUsuario(String nombre, String nombreUsuario, String apellidos){
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setApellidos(apellidos);
		Usuario aniadido = aniadirUsuario(usuario);
		
		return aniadido.getId();
	}

	private Usuario aniadirUsuario(Usuario nuevo) {
		usuarioRepository.add(nuevo);
		entityMnager.flush();
		
		return nuevo;
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.grupo8.ejercicio019.service.UsuarioService#ObtenerUsuario(java.lang.Long)
	 */
	@Override
	public Usuario obtenerUsuario(Long id){
		return usuarioRepository.read(id);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.grupo8.ejercicio019.service.UsuarioService#obtenerUsuarios()
	 */
	@Override
	public List<Usuario> obtenerUsuarios(){
		return usuarioRepository.list();
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.grupo8.ejercicio019.service.UsuarioService#actualizarUsuario(es.cic.curso.grupo8.ejercicio019.dominio.usuario.Usuario)
	 */
	@Override
	public Usuario actualizarUsuario(Usuario modificado){
		return usuarioRepository.update(modificado);
	}
	
	
	/* (non-Javadoc)
	 * @see es.cic.curso.grupo8.ejercicio019.service.UsuarioService#borrarUsuario(java.lang.Long)
	 */
	@Override
	public void borrarUsuario(Long id){
		Usuario aBorrar = obtenerUsuario(id);
		usuarioRepository.delete(aBorrar);
	}
}
