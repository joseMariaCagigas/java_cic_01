package es.cic.curso.grupo8.ejercicio019.backend.service;

import java.util.List;

import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.Url;

public interface UrlService {

	Long aniadirUrl(String enlace);
	
	Url obtenerUrl(Long id);

	Url actualizarUrl(Url modificada);

	void borrarUrl(Long id);

	List<Url> obtenerUrls();
}