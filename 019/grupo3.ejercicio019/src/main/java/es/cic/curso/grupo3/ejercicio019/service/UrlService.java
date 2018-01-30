package es.cic.curso.grupo3.ejercicio019.service;

import es.cic.curso.grupo3.ejercicio019.datos.Url;

public interface UrlService {

	Url nueva(String texto);;

	boolean modificar(Url url, String texto);

	boolean borrar(Url url);
}