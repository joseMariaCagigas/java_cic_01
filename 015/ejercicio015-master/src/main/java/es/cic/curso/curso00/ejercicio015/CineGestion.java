package es.cic.curso.curso00.ejercicio015;

public class CineGestion {
	private CineFichero dependencia;
	
	public void vender(int numeroEntradas, int sala, int sesion) {
		dependencia.guardar();
	}

	public CineFichero getDependencia() {
		return dependencia;
	}

	public void setDependencia(CineFichero cineFichero) {
		this.dependencia = cineFichero;
	}
}
