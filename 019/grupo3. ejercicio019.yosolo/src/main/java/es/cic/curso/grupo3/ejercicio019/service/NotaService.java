package es.cic.curso.grupo3.ejercicio019.service;

import java.util.List;

import es.cic.curso.grupo3.ejercicio019.datos.Nota;

//@FunctionalInterface
public interface NotaService {

	boolean check(Nota nota);

	boolean uncheck(Nota nota);

	List<Nota> listar();
	
	Nota insertarNota (Long idUsuario, Long idUrl, String texto,boolean isCheck);
}