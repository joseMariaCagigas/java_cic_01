package es.cic.curso.curso17.ejercicio016;

import java.io.Serializable;

/**
 * Representa una de las sesiones programadas para una sala de cine. Permite
 * gestionar al mismo tiempo asignación de localidades numeradas y no numeradas.
 * 
 * 
 * @author J. Francisco Martín
 * @version 20170118
 *
 */
public class Sesion implements Serializable {
	private static final long serialVersionUID = 7885734554594491269L;

	/** Disponibilidad de las localidades de la sala para la sesión. */
	private boolean[] localidades;
	/** Indica si se puede modificar la disponibilidad de las localidades. */
	private boolean abierta;

	/**
	 * Constructor. Crea una nueva sesión con el número de localidades dadas
	 * inicializadas como disponibles.
	 * 
	 * @param capacidad
	 *            Número de localidades inicialmente disponibles para la sesión
	 */
	public Sesion(int capacidad) {
		this.localidades = new boolean[capacidad];
		this.abierta = true;
	}

	/**
	 * Abre la sesión.
	 */
	public void abre() {
		this.abierta = true;
	}

	/**
	 * @return El número de localidades de la sesión
	 */
	public int capacidad() {
		return localidades.length;
	}

	/**
	 * Modifica el estado de apertura de la sesión.
	 * 
	 * @param abierta
	 *            Verdadero si la sesión pasa a estar abierta; Falso en caso
	 *            contrario
	 */
	public void cambiaEstadoApertura(boolean abierta) {
		this.abierta = abierta;
	}

	/**
	 * Indica si la sesión está o no abierta.
	 * 
	 * @return Verdadero si la sesión está abierta; Falso en caso contrario
	 */
	public boolean estaAbierta() {
		return abierta;
	}

	/**
	 * <strong>(Gestión de localidades numeradas).</strong> Comprueba si la
	 * localidad con el índice pasado como parámetro está disponible.
	 * 
	 * @param indice
	 *            Índice de la localidad de la que se desea comprobar su
	 *            disponibilidad
	 * @return Verdadero si la localidad está disponible; Falso en caso
	 *         contrario
	 */
	public boolean estaDisponible(int indice) {
		return !localidades[indice];
	}

	/**
	 * <strong>(Gestión de localidades numeradas).</strong> Modifica la
	 * disponibilidad de la localidad con el índice pasado como parámetro.
	 * 
	 * @param indice
	 *            Índice de la localidad a la que se cambia su disponibilidad
	 * @param disponibilidad
	 *            Verdadero si la localidad pasa a estar disponible; Falso en
	 *            caso contrario
	 */
	public void cambiaDisponibilidad(int indice, boolean disponibilidad) {
		localidades[indice] = !disponibilidad;
	}

	/**
	 * <strong>(Gestión de localidades no numeradas).</strong> Si hay
	 * localidades ocupadas en la sesión, desocupa una de ellas.
	 */
	public void desocupaUnaLocalidad() {
		for (int i = 0; i < capacidad(); i++) {
			if (!estaDisponible(i)) {
				cambiaDisponibilidad(i, true);
				return;
			}
		}
	}

	/**
	 * @return Número de localidades disponibles para la sesión
	 */
	public int localidadesDisponibles() {
		int result = 0;
		for (int i = 0; i < capacidad(); i++) {
			result += estaDisponible(i) ? 1 : 0;
		}
		return result;
	}

	/**
	 * @return Número de localidades ocupadas para la sesión
	 */
	public int localidadesOcupadas() {
		return capacidad() - localidadesDisponibles();
	}

	/**
	 * <strong>(Gestión de localidades no numeradas).</strong> Recorre las
	 * localidades de la sesión hasta que encuentra una que se encuentre libre y
	 * la ocupa.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             Si no hay ninguna localidad disponible
	 */
	public void ocupaLocalidadDisponible() {
		for (int i = 0; i < capacidad(); i++) {
			if (estaDisponible(i)) {
				cambiaDisponibilidad(i, false);
				return;
			}
		}
		throw new IndexOutOfBoundsException("Todas las localidades están ocupadas.");
	}

}
