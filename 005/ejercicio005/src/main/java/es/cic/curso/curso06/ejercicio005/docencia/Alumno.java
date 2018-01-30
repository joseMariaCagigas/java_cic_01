package es.cic.curso.curso06.ejercicio005.docencia;

public class Alumno extends Persona {

	private boolean escuchando;
	
	public void taparOidos(){
		this.escuchando = true;
		System.out.println("Tapemos Oidos");
	}

	public boolean isEscuchando() {
		return escuchando;
	}

	public void setEscuchando(boolean escuchando) {
		this.escuchando = escuchando;
	}
}
