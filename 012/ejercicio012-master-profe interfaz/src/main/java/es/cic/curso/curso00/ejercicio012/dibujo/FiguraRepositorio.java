package es.cic.curso.curso00.ejercicio012.dibujo;

import java.io.IOException;

public interface FiguraRepositorio {

	void guardar(String fichero) throws IOException;

	void cargar(String fichero) throws IOException;
}
