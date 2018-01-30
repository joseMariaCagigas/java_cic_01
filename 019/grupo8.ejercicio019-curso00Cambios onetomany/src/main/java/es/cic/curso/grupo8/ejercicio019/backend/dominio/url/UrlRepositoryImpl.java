package es.cic.curso.grupo8.ejercicio019.backend.dominio.url;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo8.ejercicio019.backend.AbstractRepositoryImpl;


@Repository
@Transactional
public class UrlRepositoryImpl extends AbstractRepositoryImpl<Long, Url> implements UrlRepository {

	@Override
	public Class<Url> getClassDeT() {
		return Url.class;
	}

	@Override
	public String getNombreTabla() {
		return "`url`";
	}

}
