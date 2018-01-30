package es.cic.curso.curso05.ejercicio017;

import java.util.List;

public interface FiguraRepository {

	void add(Figura figura);

	List<Figura> list();

	void delete(Figura figura);

}