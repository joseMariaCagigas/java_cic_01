package es.cic.curso.curso17.ejercicio016;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class SesionImpl implements Serializable, SesionInterface {
	private static final long serialVersionUID = 7885734554594491269L;

	private boolean[] localidades;

	private boolean abierta;


	public SesionImpl(int capacidad) {
		this.localidades = new boolean[capacidad];
		this.abierta = true;
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#abre()
	 */
	@Override
	public void abre() {
		this.abierta = true;
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#capacidad()
	 */
	@Override
	public int capacidad() {
		return localidades.length;
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#cambiaEstadoApertura(boolean)
	 */
	@Override
	public void cambiaEstadoApertura(boolean abierta) {
		this.abierta = abierta;
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#estaAbierta()
	 */
	@Override
	public boolean estaAbierta() {
		return abierta;
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#estaDisponible(int)
	 */
	@Override
	public boolean estaDisponible(int indice) {
		return !localidades[indice];
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#cambiaDisponibilidad(int, boolean)
	 */
	@Override
	public void cambiaDisponibilidad(int indice, boolean disponibilidad) {
		localidades[indice] = !disponibilidad;
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#desocupaUnaLocalidad()
	 */
	@Override
	public void desocupaUnaLocalidad() {
		for (int i = 0; i < capacidad(); i++) {
			if (!estaDisponible(i)) {
				cambiaDisponibilidad(i, true);
				return;
			}
		}
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#localidadesDisponibles()
	 */
	@Override
	public int localidadesDisponibles() {
		int result = 0;
		for (int i = 0; i < capacidad(); i++) {
			result += estaDisponible(i) ? 1 : 0;
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#localidadesOcupadas()
	 */
	@Override
	public int localidadesOcupadas() {
		return capacidad() - localidadesDisponibles();
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SesionInterface#ocupaLocalidadDisponible()
	 */
	@Override
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
