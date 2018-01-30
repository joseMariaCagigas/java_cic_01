package es.cic.curso.curso06.ejercicio016.dto;

import java.io.Serializable;

public class Entrada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2428337750432238762L;
	private final int PRECIO = 5;
	private int numSala;
	private int numSesion;
	
	public Entrada() {
		super();
	}
	
	public Entrada(int numSala, int numSesion) {
		super();
		this.numSala = numSala;
		this.numSesion = numSesion;
	}

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		
		this.numSala = numSala;
	}

	public int getNumSesion() {
		return numSesion;
	}

	public void setNumSesion(int numSesion) {
		this.numSesion = numSesion;
	}
	
	public int getPrecio() {
		return PRECIO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PRECIO;
		result = prime * result + numSala;
		result = prime * result + numSesion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		if (PRECIO != other.PRECIO)
			return false;
		if (numSala != other.numSala)
			return false;
		if (numSesion != other.numSesion)
			return false;
		return true;
	}

	
	
}
