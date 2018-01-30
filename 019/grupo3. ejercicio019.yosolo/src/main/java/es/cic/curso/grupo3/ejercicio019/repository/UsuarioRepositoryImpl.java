package es.cic.curso.grupo3.ejercicio019.repository;

import org.springframework.stereotype.Repository;

import es.cic.curso.grupo3.ejercicio019.datos.Usuario;

@Repository
public class UsuarioRepositoryImpl  extends AbstractRepositoryImpl<Long, Usuario> implements UsuarioRepository{

		@Override
		public Class<Usuario> getClassDeT() {
			return Usuario.class;
		}

		@Override
		public String getNombreTabla() {
			return "USUARIO";
		}
}