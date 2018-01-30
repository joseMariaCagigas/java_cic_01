package es.cic.curso.curso06.ejercicio016.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3674431193182298577L;
	private int numSala;
	private int capacidad;
	private List<Sesion> sesiones = new ArrayList<>();
	
	public Sala() {
		super();
	}
	
	public Sala(int numeroSala) {
		super();
		this.numSala = numeroSala;
		if(numSala == 1){
			this.capacidad = 100;
		}else if(numSala == 2){
			this.capacidad = 50;
		}else if(numSala == 3){
			this.capacidad = 30;
		}
		
		Sesion sesion1 = new Sesion(capacidad,1);
		Sesion sesion2 = new Sesion(capacidad,2);
		Sesion sesion3 = new Sesion(capacidad,3);
		
		sesiones.add(sesion1);
		sesiones.add(sesion2);
		sesiones.add(sesion3);
		
	}
	
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public int getNumSala() {
		return numSala;
	}
	
	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidad;
		result = prime * result + numSala;
		result = prime * result + ((sesiones == null) ? 0 : sesiones.hashCode());
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
		Sala other = (Sala) obj;
		if (capacidad != other.capacidad)
			return false;
		if (numSala != other.numSala)
			return false;
		if (sesiones == null) {
			if (other.sesiones != null)
				return false;
		} else if (!sesiones.equals(other.sesiones))
			return false;
		return true;
	}
	
	
}
