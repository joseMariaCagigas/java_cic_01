package es.cic.curso.curso06.ejercicio016.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import es.cic.curso.curso06.ejercicio016.dto.Sala;

public interface TaquillaFichero {

	void guardar(String fichero, List<Sala> salas) throws IOException;

	List<Sala> cargar(String fichero) throws FileNotFoundException, IOException;

}