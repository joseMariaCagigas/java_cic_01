package es.cic.curso.curso17.ejercicio016;

public interface SesionInterface {

	void abre();

	int capacidad();

	void cambiaEstadoApertura(boolean abierta);

	boolean estaAbierta();

	boolean estaDisponible(int indice);

	void cambiaDisponibilidad(int indice, boolean disponibilidad);

	void desocupaUnaLocalidad();

	int localidadesDisponibles();

	int localidadesOcupadas();

	void ocupaLocalidadDisponible();

}