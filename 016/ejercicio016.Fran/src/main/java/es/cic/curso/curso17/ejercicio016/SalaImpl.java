package es.cic.curso.curso17.ejercicio016;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SalaImpl implements Serializable, SalaInterface {
	private static final long serialVersionUID = -8441606660787943577L;


	private final int capacidad;

	private List<SesionImpl> sesiones;


	public SalaImpl(int capacidad) {
		this.capacidad = capacidad;
		this.sesiones = new ArrayList<>();
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#agregaSesion()
	 */
	@Override
	public void agregaSesion() {
		sesiones.add(new SesionImpl(capacidad));
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#capacidad()
	 */
	@Override
	public int capacidad() {
		return this.capacidad;
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#desocupaLocalidad(int, int)
	 */
	@Override
	public void desocupaLocalidad(int idSesion, int idLocalidad) {
		SesionInterface sesion = sesiones.get(idSesion);
		sesion.cambiaDisponibilidad(idLocalidad, true);
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#desocupaLocalidad(int)
	 */
	@Override
	public void desocupaLocalidad(int idSesion) {
		SesionInterface sesion = sesiones.get(idSesion);
		sesion.desocupaUnaLocalidad();
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#estaDisponible(int, int)
	 */
	@Override
	public boolean estaDisponible(int idSesion, int idLocalidad) {
		return sesiones.get(idSesion).estaDisponible(idLocalidad);
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#limpiaSesiones()
	 */
	@Override
	public void limpiaSesiones() {
		sesiones.clear();
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#localidadesDisponibles(int)
	 */
	@Override
	public int localidadesDisponibles(int idSesion) {
		return sesiones.get(idSesion).localidadesDisponibles();
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#localidadesOcupadas(int)
	 */
	@Override
	public int localidadesOcupadas(int idSesion) {
		return sesiones.get(idSesion).localidadesOcupadas();
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#numeroSesiones()
	 */
	@Override
	public int numeroSesiones() {
		return sesiones.size();
	}

	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#entradasVendidas()
	 */
	@Override
	public int entradasVendidas() {
		int result = 0;
		for (SesionInterface sesion : sesiones) {
			result += sesion.localidadesOcupadas();
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#ocupaLocalidad(int, int)
	 */
	@Override
	public void ocupaLocalidad(int idSesion, int idLocalidad) {
		SesionInterface sesion = sesiones.get(idSesion);
		if (!sesion.estaDisponible(idLocalidad)) {
			throw new IllegalArgumentException(
					"La localidad '" + idLocalidad + "' de la sesión '" + idSesion + "' ya estaba ocupada.");
		}
		sesion.cambiaDisponibilidad(idSesion, false);
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.SalaInterface#ocupaLocalidad(int)
	 */
	@Override
	public void ocupaLocalidad(int idSesion) {
		SesionInterface sesion = sesiones.get(idSesion);
		sesion.ocupaLocalidadDisponible();
	}

}
