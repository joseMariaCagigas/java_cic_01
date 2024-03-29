package es.cic.curso.curso05.ejercicio014.dominio;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.cic.curso.curso05.ejercicio014.dominio.producto.Producto;
import es.cic.curso.curso05.ejercicio014.dominio.producto.ProductoRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"classpath:es/cic/curso/curso05/ejercicio014/applicationContext.xml"
				})

public class ProductoRepositoryTest extends AbstractRepositoryImplTest<Long, Producto> {

	@Autowired
	private ProductoRepository sut;
	
	@Before
	public void setUp() throws Exception {
	}

	@Override
	public IRepository<Long, Producto> getRepository() {
		return sut;
	}

	@Override
	public Producto getInstanceDeTParaNuevo() {
		Producto producto = new Producto();
		producto.setCodigoBarras(1);
		producto.setNombre("cafe");
		producto.setPrecio(4);
		producto.setUnidadesTienda(10);
		producto.setUnidadesAlmacen(14);
		return producto;
	}

	@Override
	public Producto getInstanceDeTParaLectura() {
		Producto producto = new Producto();
		producto.setCodigoBarras(1);
		producto.setNombre("cafe");
		producto.setPrecio(4);
		producto.setUnidadesTienda(10);
		producto.setUnidadesAlmacen(14);
		return producto;
	}

	@Override
	public boolean sonDatosIguales(Producto t1, Producto t2) {
		if (t1 == null || t2 == null) {
			throw new UnsupportedOperationException("No puedo comparar nulos");
		}
		if (t1.getCodigoBarras() != t2.getCodigoBarras()) {
			return false;
		}
		
		if (t1.getNombre() != t2.getNombre()) {
			return false;
		}
		if (t1.getPrecio() != t2.getPrecio()) {
			return false;
		}
		if (t1.getUnidadesAlmacen() != t2.getUnidadesAlmacen()) {
			return false;
		}	
		if (t1.getUnidadesTienda() != t2.getUnidadesTienda()) {
			return false;
		}
		
		return true;
	}

	@Override
	public Long getClavePrimariaNoExistente() {
		return Long.MAX_VALUE;
	}

	@Override
	public Producto getInstanceDeTParaModificar(Long clave) {
		Producto producto = getInstanceDeTParaLectura();
		producto.setId(clave);
		producto.setPrecio(6);;
		return producto;
	}

}
