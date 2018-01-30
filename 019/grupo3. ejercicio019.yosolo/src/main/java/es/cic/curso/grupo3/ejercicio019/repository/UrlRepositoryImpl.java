package es.cic.curso.grupo3.ejercicio019.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo3.ejercicio019.datos.Url;

@Repository
@Transactional
public class UrlRepositoryImpl extends AbstractRepositoryImpl<Long, Url> implements UrlRepository {

	@Override
	public Class<Url> getClassDeT() {
		return Url.class;
	}

	@Override
	public String getNombreTabla() {
		return "URL";
	}	
}