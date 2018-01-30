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

/**
 * Gestiona la venta de entradas de un cine.
 * 
 * 
 * @author J. Francisco Martín
 * @version 20170118
 *
 */
public class GestorTaquilla {

	/**
	 * Nombre del fichero utilizado por defecto para almacenar los datos de la
	 * taquilla.
	 */
	public static final String FICHERO_POR_DEFECTO = "taquilla.dat";
	/** Precio fijo inicial de todas las entradas. */
	public static final double PRECIO = 5.0;

	/** Lista de salas del cine. */
	private List<Sala> salas;

	/**
	 * Constructor. Crea un nuevo objeto para la gestión de la taquilla a partir
	 * de un conjunto de salas de cine sobre las que pueden añadirse sesiones.
	 * 
	 * @param salas
	 *            Conjunto de salas sobre las que se opera la taquilla
	 */
	public GestorTaquilla(Set<Sala> salas) {
		this.salas = new ArrayList<>(salas);
	}

	/**
	 * Guarda en un fichero binario las salas registradas en el gestor.
	 * 
	 * @throws IOException
	 *             Si se produce un error inesperado de E/S
	 */
	private void guardaEnFichero() throws IOException {
		String nombreFichero = FICHERO_POR_DEFECTO; // TODO refactorizar
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
			for (Sala sala : salas) {
				oos.writeObject(sala);
			}
		}
	}

	/**
	 * Retorna el número de localidades disponibles para una sala y una sesión
	 * dadas.
	 * 
	 * @param idSala
	 *            Identificador de la sala
	 * @param idSesion
	 *            Identificador de la sesión
	 * @return Número de localidades disponibles para la sala y la sesión
	 *         indicadas
	 */
	public int localidadesDisponibles(int idSala, int idSesion) {
		Sala sala = salas.get(idSala);
		return sala.localidadesDisponibles(idSesion);
	}

	/**
	 * Retorna la recaudación de la sala pasada como parámetro.
	 * 
	 * @param idSala
	 *            Identificador de la sala
	 * @return Recaudación de la sala indicada
	 */
	public double obtenRecaudacion(int idSala) {
		Sala sala = salas.get(idSala);
		return PRECIO * sala.entradasVendidas();
	}

	/**
	 * Retorna la recaudación total de todas las salas del cine.
	 * 
	 * @return Recaudación total de todas las salas
	 */
	public double obtenRecaudacionTotal() {
		double result = 0.0;
		for (int i = 0; i < salas.size(); i++) {
			result += obtenRecaudacion(i);
		}
		return result;
	}

	/**
	 * <strong>(Gestión de localidades numeradas).</strong> Vende la entrada
	 * para la sala, sesión y localidad indicadas.
	 * 
	 * @param idSala
	 *            Identificador de la sala
	 * @param idSesion
	 *            Identificador de la sesión
	 * @param idLocalidad
	 *            Identificador de la localidad
	 * @throws IllegalArgumentException
	 *             Si para la sala y sesión indicadas, la localidad
	 *             <em>idLocalidad</em> ya está ocupada
	 * @throws IOException
	 *             Si se produce un error durante la operación de escritura en
	 *             fichero
	 */
	public void vendeEntrada(int idSala, int idSesion, int idLocalidad) throws IOException {
		Sala sala = salas.get(idSala);
		sala.ocupaLocalidad(idSesion, idLocalidad);
		guardaEnFichero();
	}

	/**
	 * <strong>(Gestión de localidades no numeradas).</strong> Vende una entrada
	 * para la sala y sesión indicadas.
	 * 
	 * @param idSala
	 *            Identificador de la sala
	 * @param idSesion
	 *            Identificador de la sesión
	 * @throws IndexOutOfBoundsException
	 *             Si para la sala y sesión indicadas, no hay localidades
	 *             disponibles
	 * @throws IOException
	 *             Si se produce un error durante la operación de escritura en
	 *             fichero
	 */
	public void vendeEntrada(int idSala, int idSesion) throws IOException {
		Sala sala = salas.get(idSala);
		sala.ocupaLocalidad(idSesion);
		guardaEnFichero();
	}

	/**
	 * Vende varias entradas para la sala y la sesión indicadas.
	 * 
	 * @param idSala
	 *            Identificador de la sala
	 * @param idSesion
	 *            Identificador de la sesión
	 * @param nEntradas
	 *            Número de entradas
	 * @throws IndexOutOfBoundsException
	 *             Si para la sala y sesión indicadas, hay menos localidades
	 *             disponibles de las que se intentan vender
	 * @throws IOException
	 *             Si se produce un error durante la operación de escritura en
	 *             fichero
	 */
	public void vendeEntradas(int idSala, int idSesion, int nEntradas) throws IOException {
		Sala sala = salas.get(idSala);
		int localidadesDisponibles = sala.localidadesDisponibles(idSesion);
		if (localidadesDisponibles < nEntradas) {
			throw new IndexOutOfBoundsException("El número de localidades disponibles '" + localidadesDisponibles
					+ "' es inferior al número de entradas '" + nEntradas + "'");
		}
		for (int i = 0; i < nEntradas; i++) {
			vendeEntrada(idSala, idSesion);
		}
	}

	/**
	 * Retorna un nuevo objeto <code>GestorTaquilla</code> a partir de los datos
	 * de salas guardados en un fichero binario.
	 * 
	 * @param nombreFichero
	 *            Nombre del fichero binario en el que están registradas las
	 *            salas
	 * @return Nuevo objeto <code>GestorTaquilla</code> inicializado a partir de
	 *         los datos de salas guardados en el fichero
	 * @throws IOException
	 */
	public static GestorTaquilla cargaDeFichero(String nombreFichero) throws IOException {
		Set<Sala> conjuntoSalas = new HashSet<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				Sala sala = (Sala) ois.readObject();
				conjuntoSalas.add(sala);
			}
		} catch (EOFException eofe) {
			// End of file
		} catch (FileNotFoundException | ClassNotFoundException e) {
			throw new IOException(e.getMessage(), e);
		}
		GestorTaquilla resultado = new GestorTaquilla(conjuntoSalas);
		return resultado;
	}

}
