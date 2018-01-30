package es.cic.curso.curso17.ejercicio016;

import java.io.IOException;

public interface GestorTaquillaInterface {

	String FICHERO_POR_DEFECTO = "taquilla.dat";
	double PRECIO = 5.0;

	int localidadesDisponibles(int idSala, int idSesion);

	double obtenRecaudacion(int idSala);

	double obtenRecaudacionTotal();

	void vendeEntrada(int idSala, int idSesion, int idLocalidad) throws IOException;

	void vendeEntrada(int idSala, int idSesion) throws IOException;

	void vendeEntradas(int idSala, int idSesion, int nEntradas) throws IOException;

}