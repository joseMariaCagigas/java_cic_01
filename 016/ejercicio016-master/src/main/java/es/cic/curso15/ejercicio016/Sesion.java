package es.cic.curso15.ejercicio016;

public class Sesion {
	private int idSesion;
	private int ocupadas;

	public Sesion(){
		super();
	}
	public Sesion(int ocupadas){
		this.ocupadas = ocupadas;
	}

	public int getOcupadas() {
		return ocupadas;
	}
	public void setOcupadas(int ocupadas) {
		this.ocupadas = ocupadas;
	}

	public int getIdSesion() {
		return idSesion;
	}
	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

}
