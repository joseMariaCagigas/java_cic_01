package es.cic.curso.curso17.ejercicio016;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una sala de cine sobre la que se pueden programar diferentes
 * sesiones. Permite gestionar al mismo tiempo asignación de localidades
 * numeradas y no numeradas.
 * 
 * 
 * @author J. Francisco Martín
 * @version 20170118
 *
 */
public class Sala implements Serializable {
	private static final long serialVersionUID = -8441606660787943577L;

	/** Número de localidades de la sala (valor inmutable). */
	private final int capacidad;
	/** Sesiones programadas en la sala. */
	private List<Sesion> sesiones;

	/**
	 * Constructor. Crea una nueva sala de cine con el número de localidades
	 * indicado y una lista de sesiones inicialmente vacía.
	 * 
	 * @param capacidad
	 *            Número de localidades de la sala
	 */
	public Sala(int capacidad) {
		this.capacidad = capacidad;
		this.sesiones = new ArrayList<>();
	}

	/**
	 * Inicializa y añade una nueva sesión a la sala.
	 */
	public void agregaSesion() {
		sesiones.add(new Sesion(capacidad));
	}

	/**
	 * @return La capacidad de la sala
	 */
	public int capacidad() {
		return this.capacidad;
	}

	/**
	 * <strong>(Gestión de localidades numeradas).</strong> Asegura que la
	 * localidad de la sesión indicadas a través de <em>idLocalidad</em> e
	 * <em>idSesion</em> queda disponible.
	 * 
	 * @param idSesion
	 *            Identificador de la sesión
	 * @param idLocalidad
	 *            Identificador de la localidad que se deja disponible
	 */
	public void desocupaLocalidad(int idSesion, int idLocalidad) {
		Sesion sesion = sesiones.get(idSesion);
		sesion.cambiaDisponibilidad(idLocalidad, true);
	}

	/**
	 * <strong>(Gestión de localidades no numeradas).</strong> Asegura que una
	 * de las localidades de la sesión indicada queda disponible.
	 * 
	 * @param idSesion
	 *            Identificador de la sesion
	 */
	public void desocupaLocalidad(int idSesion) {
		Sesion sesion = sesiones.get(idSesion);
		sesion.desocupaUnaLocalidad();
	}

	/**
	 * <strong>(Gestión de localidades numeradas).</strong> Comprueba si la
	 * localidad de la sesion indicadas a través de <em>idLocalidad</em> e
	 * <em>idSesion</em> está disponible.
	 * 
	 * @param idSesion
	 *            Identificador de la sesión
	 * @param idLocalidad
	 *            Identificador de la localidad
	 * @return Verdadero si la localidad está disponible; Falso en caso
	 *         contrario
	 */
	public boolean estaDisponible(int idSesion, int idLocalidad) {
		return sesiones.get(idSesion).estaDisponible(idLocalidad);
	}

	/**
	 * Borra la lista de sesiones programadas para la sala.
	 */
	public void limpiaSesiones() {
		sesiones.clear();
	}

	/**
	 * Retorna el número de localidades disponibles para la sesión indicada.
	 * 
	 * @param idSesion
	 *            Identificador de la sesión
	 * @return Número de localidades disponibles para la sesión indicada
	 */
	public int localidadesDisponibles(int idSesion) {
		return sesiones.get(idSesion).localidadesDisponibles();
	}

	/**
	 * Retorna el número de localidades ocupadas para la sesión indicada.
	 * 
	 * @param idSesion
	 *            Identificador de la sesión
	 * @return Número de localidades disponibles para la sesión indicada
	 */
	public int localidadesOcupadas(int idSesion) {
		return sesiones.get(idSesion).localidadesOcupadas();
	}

	/**
	 * @return Número de sesiones programadas para la sala
	 */
	public int numeroSesiones() {
		return sesiones.size();
	}

	/**
	 * @return Número de entradas vendidas en la sala (en todas sus sesiones)
	 */
	public int entradasVendidas() {
		int result = 0;
		for (Sesion sesion : sesiones) {
			result += sesion.localidadesOcupadas();
		}
		return result;
	}

	/**
	 * <strong>(Gestión de localidades numeradas).</strong> Ocupa la localidad
	 * de la sesión indicadas a través de <em>idLocalidad</em> e
	 * <em>idSesion</em>.
	 * 
	 * @param idSesion
	 *            Identificador de la sesión
	 * @param idLocalidad
	 *            Número de la localidad
	 * @throws IllegalArgumentException
	 *             Si para esa sesión, la localidad indicada ya está ocupada
	 */
	public void ocupaLocalidad(int idSesion, int idLocalidad) {
		Sesion sesion = sesiones.get(idSesion);
		if (!sesion.estaDisponible(idLocalidad)) {
			throw new IllegalArgumentException(
					"La localidad '" + idLocalidad + "' de la sesión '" + idSesion + "' ya estaba ocupada.");
		}
		sesion.cambiaDisponibilidad(idSesion, false);
	}

	/**
	 * <strong>(Gestión de localidades no numeradas).</strong> Ocupa una de las
	 * localidades libres de la sesión indicada.
	 * 
	 * @param idSesion
	 *            Identificador de la sesión
	 * @throws IndexOutOfBoundsException
	 *             Si no hay ninguna localidad disponible
	 */
	public void ocupaLocalidad(int idSesion) {
		Sesion sesion = sesiones.get(idSesion);
		sesion.ocupaLocalidadDisponible();
	}

}
