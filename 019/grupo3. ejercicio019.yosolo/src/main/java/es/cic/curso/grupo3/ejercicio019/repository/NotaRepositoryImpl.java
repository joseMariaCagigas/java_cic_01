package es.cic.curso.grupo3.ejercicio019.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo3.ejercicio019.datos.Nota;


	@Repository
	@Transactional
	public class NotaRepositoryImpl extends AbstractRepositoryImpl<Long, Nota> implements NotaRepository {

		@Override
		public Class<Nota> getClassDeT() {
			return Nota.class;
		}


		@Override
		public String getNombreTabla() {
			return "NOTA";
		}	
}
