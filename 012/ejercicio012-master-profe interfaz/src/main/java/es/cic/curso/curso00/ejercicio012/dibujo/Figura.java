package es.cic.curso.curso00.ejercicio012.dibujo;

import java.io.Serializable;

public class Figura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3424450249656741704L;
	private int tamanio;
	private short color;
	private byte tipo;
	private Centro centro;

	
	public Figura() {
		centro =  new Centro();
	}
	
	public Figura(int tamanio, short color, byte tipo, Centro centro) {
		super();
		this.tamanio = tamanio;
		this.color = color;
		this.tipo = tipo;
		this.centro = centro;
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public short getColor() {
		return color;
	}
	public void setColor(short color) {
		this.color = color;
	}
	public byte getTipo() {
		return tipo;
	}
	public void setTipo(byte tipo) {
		this.tipo = tipo;
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		result = prime * result + color;
		result = prime * result + tamanio;
		result = prime * result + tipo;
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
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		if (color != other.color)
			return false;
		if (tamanio != other.tamanio)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Figura [tamanio=" + tamanio + ", color=" + color + ", tipo=" + tipo + ", centro=" + centro + "]";
	}
}
