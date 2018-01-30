package es.cic.curso.curso00.ejercicio014;

public class Inventario {
	private String producto;
	private int cantidad;
	private String lugar;
	
	
	
	public Inventario(String producto, int cantidad, String lugar) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.lugar = lugar;
	}
	public Inventario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((lugar == null) ? 0 : lugar.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		Inventario other = (Inventario) obj;
		if (cantidad != other.cantidad)
			return false;
		if (lugar == null) {
			if (other.lugar != null)
				return false;
		} else if (!lugar.equals(other.lugar))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pepe [producto=" + producto + ", cantidad=" + cantidad + ", lugar=" + lugar + "]";
	}
	
	
}
