package es.cic.curso.curso05.ejercicio014.dominio.venta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import es.cic.curso.curso05.ejercicio014.dominio.Identificable;
import es.cic.curso.curso05.ejercicio014.dominio.producto.Producto;

@Entity
public class Venta implements Identificable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1859273245543912738L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
		
	@Column(name="unidades")
	private int unidades;
	
	@JoinColumn(name="producto_id")
	@OneToOne(fetch=FetchType.LAZY)
	private Producto producto;
	
	@Column(name="importe")
	private int importe;
	
	
	public Venta() {
		super();
	}

	public Venta(int unidades, Producto producto, int importe) {
		super();
		this.unidades = unidades;
		this.producto = producto;
		this.importe = importe;
	}

	public Venta(Long id, int unidades, Producto producto, int importe) {
		super();
		this.id = id;
		this.unidades = unidades;
		this.producto = producto;
		this.importe = importe;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public int getUnidades() {
		return unidades;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Venta other = (Venta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", unidades=" + unidades + ", productoId=" + producto.getId() + ", importe=" + importe
				+ "]";
	}

}
