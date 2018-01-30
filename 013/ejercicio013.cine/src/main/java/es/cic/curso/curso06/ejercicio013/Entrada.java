package es.cic.curso.curso06.ejercicio013;


public class Entrada {
	
	private int numeroEntrada;
	private Sesion sesionEntrada;
	
	public Entrada(){
		super();
	}

	public Entrada(int numeroEntrada, Sesion sesionEntrada) {
		super();
		this.numeroEntrada = numeroEntrada;
		this.sesionEntrada = sesionEntrada;
	}

	public int getNumeroEntrada() {
		return numeroEntrada;
	}

	public void setNumeroEntrada(int numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}

	public Sesion getSesionEntrada() {
		return sesionEntrada;
	}

	public void setSesionEntrada(Sesion sesionEntrada) {
		this.sesionEntrada = sesionEntrada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroEntrada;
		result = prime * result + ((sesionEntrada == null) ? 0 : sesionEntrada.hashCode());
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
		if (numeroEntrada != other.numeroEntrada)
			return false;
		if (sesionEntrada == null) {
			if (other.sesionEntrada != null)
				return false;
		} else if (!sesionEntrada.equals(other.sesionEntrada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entrada [numeroEntrada=" + numeroEntrada + ", sesionEntrada=" + sesionEntrada + "]";
	}


}
