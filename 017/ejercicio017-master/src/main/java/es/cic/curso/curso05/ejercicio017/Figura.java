package es.cic.curso.curso05.ejercicio017;

public class Figura {
	private int tam;
	private short color;
	private byte tipo;
	private Centro centro;
	private float rotacion;

	public Figura(){
		centro = new Centro();
	}

	/*Circulo*/
	public Figura(int tam, short color, byte tipo, Centro centro) {
		super();
		this.tam = tam*2;
		this.color = color;
		this.tipo = tipo;
		this.centro = centro;
		this.rotacion = 0;
	}

	/*Cuadrado*/
	public Figura(int lado, short color, byte tipo, float rotacion) {
		super();
		this.tam = lado;
		this.color = color;
		this.tipo = tipo;
		this.centro = null;
		this.rotacion = rotacion;
	}
	
	/*Linea*/
	public Figura(int longitud, short color, byte tipo, Centro centro, float rotacion) {
		super();
		this.tam = longitud;
		this.color = color;
		this.tipo = tipo;
		this.centro = centro;
		this.rotacion = rotacion;
	}
	
	/*Punto*/
	public Figura(short color, byte tipo, Centro centro) {
		super();
		this.tam = 0;
		this.color = color;
		this.tipo = tipo;
		this.centro = centro;
		this.rotacion = 0;
	}
	
	public int getTam() {
		return tam;
	}
	public void setTam(int tam) {
		this.tam = tam;
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
	public float getRotacion() {
		return rotacion;
	}

	public void setRotacion(float rotacion) {
		this.rotacion = rotacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		result = prime * result + color;
		result = prime * result + Float.floatToIntBits(rotacion);
		result = prime * result + tam;
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
		if (Float.floatToIntBits(rotacion) != Float.floatToIntBits(other.rotacion))
			return false;
		if (tam != other.tam)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Figura [tam=" + tam + ", color=" + color + ", tipo=" + tipo + ", centro=" + centro + ", rotacion="
				+ rotacion + "]";
	}
	
}
