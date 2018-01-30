package es.cic.curso15.ejercicio016;

import java.util.List;

public class SalaCine {
	private int idSala;
	private List<Sesion> sesion;
	private int aforo;
	
	public SalaCine(){
		super();
	}
	public SalaCine (int aforo, List<Sesion> sesion){
		this.aforo = aforo;
		this.sesion = sesion;
	}
	
	
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public List<Sesion> getSesion() {
		return sesion;
	}
	public void setSesion(List<Sesion> sesion) {
		this.sesion = sesion;
	}
	
}