package es.cic.curso.curso05.ejercicio014.service;

import java.util.List;

import es.cic.curso.curso05.ejercicio014.dominio.producto.Producto;
import es.cic.curso.curso05.ejercicio014.dominio.venta.Venta;

public interface TiendaService {

	Long aniadirProducto(int codigoBarras, String cafe, int precio, int udsTienda, int udsAlmacen);

	Producto obtenerProducto(Long id);

	List<Producto> obtenerProductos();

	int obtenerUdsProducto(Long id);

	boolean hayProducto(Long id, int numeroProductos);

	Long vender(Long id, int numUnidades) throws NoHayUnidadesSuficientesException;

	Producto actualizarProducto(Producto modificado);

	Long aniadirVenta(int unidades, Long productoId, int importe);

	List<Venta> obtenerVentas();

}