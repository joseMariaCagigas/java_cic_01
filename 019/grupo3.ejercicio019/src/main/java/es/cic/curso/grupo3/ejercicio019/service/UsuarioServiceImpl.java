package es.cic.curso.grupo3.ejercicio019.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.cic.curso.grupo3.ejercicio019.datos.Usuario;
import es.cic.curso.grupo3.ejercicio019.repository.UsuarioRepository;


@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario insertarUsuario (String usuario, String password){
		Usuario user = new Usuario(usuario,password);
		return usuarioRepository.add(user);
		
		
	}
	@Override
	public void borrarUsuario (Long id){
		Usuario usuarioABorrar = usuarioRepository.read(id);	
		usuarioRepository.delete(usuarioABorrar);
		
	}
}
