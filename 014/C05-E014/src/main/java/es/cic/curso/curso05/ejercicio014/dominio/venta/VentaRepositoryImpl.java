package es.cic.curso.curso05.ejercicio014.dominio.venta;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.curso05.ejercicio014.dominio.AbstractRepositoryImpl;

@Repository
@Transactional
public class VentaRepositoryImpl extends AbstractRepositoryImpl<Long, Venta> implements VentaRepository {

	@Override
	public Class<Venta> getClassDeT() {
		return Venta.class;
	}

	@Override
	public String getNombreTabla() {
		return "venta";
	}
	
}
