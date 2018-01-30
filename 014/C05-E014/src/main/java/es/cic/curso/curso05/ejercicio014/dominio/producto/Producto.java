package es.cic.curso.curso05.ejercicio014.dominio.producto;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.cic.curso.curso05.ejercicio014.dominio.Identificable;
import es.cic.curso.curso05.ejercicio014.dominio.venta.Venta;

@Entity
public class Producto implements Identificable<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5398660631489246830L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="codigo_barras")
	private int codigoBarras;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private int precio;
	
	@Column(name="unidades_tienda")
	private int unidadesTienda;
	
	@Column(name="unidades_almacen")
	private int unidadesAlmacen;
	
	@OneToMany(mappedBy="producto") //esto es el nombre del variable en  la clase
	private List<Venta>listaVentas = new ArrayList<>();
	
	public Producto(){
		super();
	}
	
	public Producto(int codigoBarras, String nombre, int precio, int unidadesTienda, int unidadesAlmacen){
		super();
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.precio = precio;
		this.unidadesTienda = unidadesTienda;
		this.unidadesAlmacen = unidadesAlmacen;
	}
	
	

	public Producto(Long id, int codigoBarras, String nombre, int precio, int unidadesTienda, int unidadesAlmacen) {
		super();
		this.id = id;
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.precio = precio;
		this.unidadesTienda = unidadesTienda;
		this.unidadesAlmacen = unidadesAlmacen;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getUnidadesTienda() {
		return unidadesTienda;
	}

	public void setUnidadesTienda(int unidadesTienda) {
		this.unidadesTienda = unidadesTienda;
	}

	public int getUnidadesAlmacen() {
		return unidadesAlmacen;
	}

	public void setUnidadesAlmacen(int unidadesAlmacen) {
		this.unidadesAlmacen = unidadesAlmacen;
	}

	public List<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoBarras;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Producto other = (Producto) obj;
		if (codigoBarras != other.codigoBarras)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", unidadesTienda=" + unidadesTienda
				+ ", unidadesAlmacen=" + unidadesAlmacen + "]";
	}

	
	
}
