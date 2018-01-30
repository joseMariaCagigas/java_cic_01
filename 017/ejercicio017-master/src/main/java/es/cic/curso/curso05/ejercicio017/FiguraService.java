package es.cic.curso.curso05.ejercicio017;

import java.util.List;

public interface FiguraService {

	List<Figura> listar();

	void anadir(Figura figura);

	void borrar(Figura figura);

}