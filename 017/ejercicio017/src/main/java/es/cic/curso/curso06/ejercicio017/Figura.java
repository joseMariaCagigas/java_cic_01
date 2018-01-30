package es.cic.curso.curso06.ejercicio017;

import java.io.Serializable;

public class Figura implements Serializable {

	private static final long serialVersionUID = -9188615469165830445L;
	private int color;
	private Punto punto;

	public Figura(int color, Punto punto) {
		super();
		this.color = color;
		this.punto = punto;
	}
	
	public Figura() {
		super();
		punto = new Punto();
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + color;
		result = prime * result + ((punto == null) ? 0 : punto.hashCode());
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
		Figura other = (Figura) obj;
		if (color != other.color)
			return false;
		if (punto == null) {
			if (other.punto != null)
				return false;
		} else if (!punto.equals(other.punto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Figura [color=" + color + ", punto=" + punto + "]";
	}

}
