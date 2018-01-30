package es.cic.curso.curso06.ejercicio013;


public class Sesion {
	
	private int nrosecion;
	

	private Sala sala;
	private int butacasDisp;

	
	
	public Sesion(int nrosecion,  int asientosDisponibles ) {

		this.nrosecion = nrosecion;
		this.butacasDisp = asientosDisponibles;
	}
	
	public int VenderButacas(int butacasVendidas){
		butacasDisp = butacasDisp - butacasVendidas;
		return butacasDisp;
	}

	

	public int getNrosecion() {
		return nrosecion;
	}

	public void setNrosecion(int nrosecion) {
		this.nrosecion = nrosecion;
	}


	public int getButacasDisp() {
		return butacasDisp;
	}

	public void setButacasDisp(int butacasDisp) {
		this.butacasDisp = butacasDisp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + butacasDisp;
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
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
		if (butacasDisp != other.butacasDisp)
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sesion [sala=" + sala + ", asientosDisponibles=" + butacasDisp + "]";
	}



	
}