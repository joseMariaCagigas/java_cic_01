package es.cic.curso.curso00.ejercicio012.dibujo;

import java.util.List;

public interface FiguraServicios {

	void nuevo(Figura figura);

	List<Figura> listar();

	void borrar(int indice);


}