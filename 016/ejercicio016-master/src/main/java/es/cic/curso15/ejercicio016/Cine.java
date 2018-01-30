package es.cic.curso15.ejercicio016;

import java.util.List;

public class Cine {
	private List<SalaCine> salas;
	private int recaudacion;
	
	public Cine(){
		super();
	}
	public Cine(List<SalaCine> sala, int recaudacion){
		this.salas = sala;
		this.recaudacion = recaudacion;
	}
	public List<SalaCine> getSalas() {
		return salas;
	}
	public void setSalas(List<SalaCine> salas) {
		this.salas = salas;
	}
	public int getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(int recaudacion) {
		this.recaudacion = recaudacion;
	}
	
}