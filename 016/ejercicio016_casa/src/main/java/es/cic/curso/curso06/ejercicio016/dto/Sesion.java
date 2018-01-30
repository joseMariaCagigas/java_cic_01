package es.cic.curso.curso06.ejercicio016.dto;

import java.io.Serializable;

public class Sesion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8503255091410808137L;
	private int numSesion;
	private int numButacas;
	private int butacasOcupadas;
	private int butacasLibres;
	
	
	public Sesion() {
		super();
	}
	
	public Sesion(int numeroButacas, int numeroSesion) {
		super();
		this.numSesion = numeroSesion;
		this.numButacas = numeroButacas;
		this.butacasOcupadas = 0;
		this.butacasLibres = numeroButacas - this.butacasOcupadas;
	}

	public int getNumSesion() {
		return numSesion;
	}

	public void setNumSesion(int numSesion) {
		this.numSesion = numSesion;
	}

	public int getNumButacas() {
		return numButacas;
	}

	public void setNumButacas(int numButacas) {
		this.numButacas = numButacas;
	}

	public int getButacasLibres() {
		return butacasLibres;
	}

	public void setButacasLibres(int entradasCompradas) {
		this.butacasLibres -= entradasCompradas;
	}

	public int getButacasOcupadas() {
		return butacasOcupadas;
	}

	public void setButacasOcupadas(int butacasOcupadas) {
		this.butacasOcupadas += butacasOcupadas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + butacasLibres;
		result = prime * result + butacasOcupadas;
		result = prime * result + numButacas;
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
		Sesion other = (Sesion) obj;
		if (butacasLibres != other.butacasLibres)
			return false;
		if (butacasOcupadas != other.butacasOcupadas)
			return false;
		if (numButacas != other.numButacas)
			return false;
		if (numSesion != other.numSesion)
			return false;
		return true;
	}
	
	
}
