package es.cic.curso.curso17.ejercicio016;

public interface SalaInterface {

	void agregaSesion();

	int capacidad();

	void desocupaLocalidad(int idSesion, int idLocalidad);

	void desocupaLocalidad(int idSesion);

	boolean estaDisponible(int idSesion, int idLocalidad);

	void limpiaSesiones();

	int localidadesDisponibles(int idSesion);

	int localidadesOcupadas(int idSesion);

	int numeroSesiones();

	int entradasVendidas();

	void ocupaLocalidad(int idSesion, int idLocalidad);

	void ocupaLocalidad(int idSesion);

}