package es.cic.curso.curso06.ejercicio013;

import java.util.ArrayList;
import java.util.List;

public class Sala
{

	private int numeroSala;
	private int butacasTotales;
	private List<Sesion> sesiones;
	

	public Sala(int numeroSala, int butacasTotales){
		this.numeroSala=numeroSala;
		this.butacasTotales=butacasTotales;
		sesiones = new ArrayList<>();
		sesiones.add(new Sesion(1, butacasTotales));
		sesiones.add(new Sesion(2, butacasTotales));
		sesiones.add(new Sesion(3, butacasTotales));
	}
	
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}
	public void setButacasTotales(int butacasTotales) {
		this.butacasTotales = butacasTotales;
	}
	public int getButacasTotales() {
		return butacasTotales;
	}
	
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	
}
