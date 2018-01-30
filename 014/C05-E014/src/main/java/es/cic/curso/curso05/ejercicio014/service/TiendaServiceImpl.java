package es.cic.curso.curso05.ejercicio014.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.curso05.ejercicio014.dominio.producto.Producto;
import es.cic.curso.curso05.ejercicio014.dominio.producto.ProductoRepository;
import es.cic.curso.curso05.ejercicio014.dominio.venta.Venta;
import es.cic.curso.curso05.ejercicio014.dominio.venta.VentaRepository;

@Service
public class TiendaServiceImpl implements TiendaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	@Autowired 
	private ProductoRepository productoRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public Long aniadirProducto(int codigoBarras, String cafe, int precio, int udsTienda, int udsAlmacen){
		Producto nuevo = new Producto();
		nuevo.setCodigoBarras(codigoBarras);
		nuevo.setNombre(cafe);
		nuevo.setPrecio(precio);
		nuevo.setUnidadesTienda(udsTienda);
		nuevo.setUnidadesAlmacen(udsAlmacen);
		Producto aniadido = aniadirProducto(nuevo);
		
		return aniadido.getId();
	}

	private Producto aniadirProducto(Producto nuevo){
		productoRepository.add(nuevo);
		entityManager.flush();
		return nuevo;
	}
	
	
	@Override
	public Producto obtenerProducto(Long id){
		return productoRepository.read(id);
	}
	
	
	@Override
	public List<Producto> obtenerProductos(){
		return productoRepository.list();
	}
	
	
	@Override
	public int obtenerUdsProducto(Long id){
		Producto resultado = productoRepository.read(id);
		return resultado.getUnidadesTienda() + resultado.getUnidadesAlmacen();
	}
	
	
	@Override
	public boolean hayProducto(Long id, int numeroProductos){
		if(obtenerUdsProducto(id) >= numeroProductos){
			return true;
		}
		return false;
	}
	
	
	@Override
	public Long vender(Long id, int numUnidades) throws NoHayUnidadesSuficientesException{
		int importe;
		
		if(!hayProducto(id, numUnidades)){
			throw new NoHayUnidadesSuficientesException("No que hay unidades suficientes");
		}
		
		Producto producto = obtenerProducto(id);
		actualizarTienda(producto, numUnidades);
		
		importe = numUnidades * producto.getPrecio();
		
		return aniadirVenta(numUnidades, id, importe);
	}
	
	private void actualizarTienda(Producto producto, int numUnidades){
		if(numUnidades < producto.getUnidadesTienda()){
			producto.setUnidadesTienda(producto.getUnidadesTienda() - numUnidades);
			actualizarProducto(producto);
		}else if(numUnidades == producto.getUnidadesTienda()){
			producto.setUnidadesTienda(0);
			actualizarProducto(producto);
		}else{
			int udsRestantes = numUnidades - producto.getUnidadesTienda();
			producto.setUnidadesTienda(0);
			if(udsRestantes < producto.getUnidadesAlmacen()){
				producto.setUnidadesAlmacen(producto.getUnidadesAlmacen() - udsRestantes);
				actualizarProducto(producto);
			}else if(udsRestantes == producto.getUnidadesAlmacen()){
				producto.setUnidadesAlmacen(0);
			}
		}
	}
	
	@Override
	public Producto actualizarProducto(Producto modificado){
		return productoRepository.update(modificado);
	}

	@Override
	public Long aniadirVenta(int unidades, Long productoId, int importe){
		Venta nueva = new Venta();
		nueva.setUnidades(unidades);
		Producto producto = productoRepository.read(productoId);
		nueva.setProducto(producto);
		nueva.setImporte(importe);
		Venta aniadida = aniadirVenta(nueva);
		
		return aniadida.getId();
	}
	
	private Venta aniadirVenta(Venta nueva){
		ventaRepository.add(nueva);
		return nueva;
	}
	
	@Override
	public List<Venta> obtenerVentas(){
		return ventaRepository.list();
	}
}
