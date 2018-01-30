package es.cic.curso.curso17.ejercicio016;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class GestorTaquillaImpl implements GestorTaquillaInterface {


	private List<SalaImpl> salas;

	public GestorTaquillaImpl(Set<SalaImpl> salas) {
		this.salas = new ArrayList<>(salas);
	}

	private void guardaEnFichero() throws IOException {
		guardarEnFichero();
	}

	private void guardarEnFichero() throws IOException, FileNotFoundException {
		String nombreFichero = FICHERO_POR_DEFECTO; // TODO refactorizar
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
			for (SalaInterface sala : salas) {
				oos.writeObject(sala);
			}
		}
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.GestorTaquillaInterface#localidadesDisponibles(int, int)
	 */
	@Override
	public int localidadesDisponibles(int idSala, int idSesion) {
		SalaInterface sala = salas.get(idSala);
		return sala.localidadesDisponibles(idSesion);
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.GestorTaquillaInterface#obtenRecaudacion(int)
	 */
	@Override
	public double obtenRecaudacion(int idSala) {
		SalaInterface sala = salas.get(idSala);
		return PRECIO * sala.entradasVendidas();
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.GestorTaquillaInterface#obtenRecaudacionTotal()
	 */
	@Override
	public double obtenRecaudacionTotal() {
		double result = 0.0;
		for (int i = 0; i < salas.size(); i++) {
			result += obtenRecaudacion(i);
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.GestorTaquillaInterface#vendeEntrada(int, int, int)
	 */
	@Override
	public void vendeEntrada(int idSala, int idSesion, int idLocalidad) throws IOException {
		SalaInterface sala = salas.get(idSala);
		sala.ocupaLocalidad(idSesion, idLocalidad);
		guardaEnFichero();
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.GestorTaquillaInterface#vendeEntrada(int, int)
	 */
	@Override
	public void vendeEntrada(int idSala, int idSesion) throws IOException {
		SalaInterface sala = salas.get(idSala);
		sala.ocupaLocalidad(idSesion);
		guardaEnFichero();
	}


	/* (non-Javadoc)
	 * @see es.cic.curso.curso17.ejercicio016.GestorTaquillaInterface#vendeEntradas(int, int, int)
	 */
	@Override
	public void vendeEntradas(int idSala, int idSesion, int nEntradas) throws IOException {
		SalaInterface sala = salas.get(idSala);
		int localidadesDisponibles = sala.localidadesDisponibles(idSesion);
		if (localidadesDisponibles < nEntradas) {
			throw new IndexOutOfBoundsException("El número de localidades disponibles '" + localidadesDisponibles
					+ "' es inferior al número de entradas '" + nEntradas + "'");
		}
		for (int i = 0; i < nEntradas; i++) {
			vendeEntrada(idSala, idSesion);
		}
	}


	public static GestorTaquillaInterface cargaDeFichero(String nombreFichero) throws IOException {
		return cargarFichero(nombreFichero);
	}

	private static GestorTaquillaInterface cargarFichero(String nombreFichero) throws IOException {
		Set<SalaImpl> conjuntoSalas = new HashSet<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				SalaImpl sala = (SalaImpl) ois.readObject();
				conjuntoSalas.add(sala);
			}
		} catch (EOFException eofe) {
			// End of file
		} catch (FileNotFoundException | ClassNotFoundException e) {
			throw new IOException(e.getMessage(), e);
		}
		GestorTaquillaInterface resultado = new GestorTaquillaImpl(conjuntoSalas);
		return resultado;
	}

}
