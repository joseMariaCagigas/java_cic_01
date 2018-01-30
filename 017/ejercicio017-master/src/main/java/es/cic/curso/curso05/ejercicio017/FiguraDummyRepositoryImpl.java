package es.cic.curso.curso05.ejercicio017;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class FiguraDummyRepositoryImpl implements FiguraRepository {

	private Figura slot1;
	private Figura slot2;
	
	@Override
	public void add(Figura figura) {
		if (slot1 == null) {
			slot1 = figura;
		} else if (slot2 == null) {
			slot2 = figura;
		} else {
			throw new RuntimeException("No quedan posiciones libres");
		}

	}

	@Override
	public List<Figura> list() {
		List<Figura> resultado = new ArrayList<>();
		if (slot1 != null) {
			resultado.add(slot1);
		}
		if (slot2 != null) {
			resultado.add(slot2);
		} 

		return resultado;
	}

	@Override
	public void delete(Figura figura) {
		if (figura.equals(slot1)) {
			slot1 = null;
		} else if (figura.equals(slot2)) {
			slot2 = null;
		} else {
			throw new RuntimeException("Me has pedido borra algo que no tengo");
		}
	}

}
