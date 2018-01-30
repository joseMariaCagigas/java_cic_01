package es.cic.curso.grupo3.ejercicio019.service;

import es.cic.curso.grupo3.ejercicio019.datos.Usuario;

public interface UsuarioService {

	

	Usuario insertarUsuario(String usuario, String password);

	void borrarUsuario(Long id);

}
