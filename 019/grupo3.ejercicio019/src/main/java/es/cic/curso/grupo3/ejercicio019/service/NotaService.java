package es.cic.curso.grupo3.ejercicio019.service;

import java.util.List;

import es.cic.curso.grupo3.ejercicio019.datos.Nota;
import es.cic.curso.grupo3.ejercicio019.datos.Url;
import es.cic.curso.grupo3.ejercicio019.datos.Usuario;

//@FunctionalInterface
public interface NotaService {

	boolean check(Nota nota);

	boolean uncheck(Nota nota);

	List<Nota> listar();

	Nota insertarNota(Usuario usuario, Url url, String texto, boolean check);

	Nota insertarNota(Long long1, String texto, boolean check);
}