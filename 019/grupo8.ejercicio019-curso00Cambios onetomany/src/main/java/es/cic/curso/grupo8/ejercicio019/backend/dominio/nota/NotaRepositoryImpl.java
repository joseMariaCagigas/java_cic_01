package es.cic.curso.grupo8.ejercicio019.backend.dominio.nota;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo8.ejercicio019.backend.AbstractRepositoryImpl;

@Repository
@Transactional
public class NotaRepositoryImpl extends AbstractRepositoryImpl<Long, Nota> implements NotaRepository {

	@Override
	public Class<Nota> getClassDeT() {
		
		return Nota.class;
	}

	@Override
	public String getNombreTabla() {
		
		return "`nota`";
	}
}
