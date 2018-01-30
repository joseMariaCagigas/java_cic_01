package es.cic.curso.curso06.ejercicio017;

import java.util.List;

public interface RepositoryFiguraImpl {

	void agregarFigura(Figura figura);

	List<Figura> listarFiguras();

	void borrarFigura(int indice);

	List<Figura> vaciarLista();

}