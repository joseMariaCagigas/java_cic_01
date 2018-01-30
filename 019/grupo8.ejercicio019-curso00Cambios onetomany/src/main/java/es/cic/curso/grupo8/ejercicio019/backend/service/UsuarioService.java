package es.cic.curso.grupo8.ejercicio019.backend.service;

import java.util.List;

import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.Usuario;

public interface UsuarioService {

	Long aniadirUsuario(String nombre, String nombreUsuario, String apellidos);

	Usuario obtenerUsuario(Long id);

	Usuario actualizarUsuario(Usuario modificado);

	void borrarUsuario(Long id);

	List<Usuario> obtenerUsuarios();
}