package es.cic.curso.grupo8.ejercicio019.backend.service;

import java.util.List;

import es.cic.curso.grupo8.ejercicio019.backend.dominio.nota.Nota;

public interface NotaService {

	Long aniadirNota(Long idUsuario, String contenido);
	
	Long aniadirNotaConUrl(Long idUsuario, String contenido, Long idURL);
	
	Nota obtenerNota(Long id);

	Nota actualizarNota(Nota notaModificada);

	void borrarNota(Long id);

	List<Nota> obtenerNotas();
	
	List<Nota> obtenerNotasUsuario(Long idUsuario);
}