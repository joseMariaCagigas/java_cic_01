package es.cic.curso.curso00.ejercicio014;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventarioFichero {
	public static final String TIENDA = "TIENDA";
	public static final String ALMACEN = "ALMACEN";
	
	
	public static final String GALLETAS = "GALLETAS";
	public static final String CAFE = "CAFE";
	public static final String LECHE = "LECHE";
	
	private Map<String, Integer> precios = new HashMap<>();
	
	public InventarioFichero() {
		precios.put(GALLETAS, 2);
		precios.put(CAFE, 4);
		precios.put(LECHE, 1);
	}
	
	public List<Inventario> cargar() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("./src/test/resources/inventario.txt"))) {
			String linea;
			List<Inventario> resultado = new ArrayList<>();
			while ((linea = br.readLine()) != null) {
				String[] valores = linea.split(";");
				Inventario dato = new Inventario(
							valores[0],
							Integer.parseInt(valores[1]),
							valores[2]
						);
				resultado.add(dato);				
			}
			return resultado;
		}
	}
	
	public int cuantosDisponibles(String producto, List<Inventario> listaInventario) {
		int suma = 0;
		
		for (Inventario entrada: listaInventario) {
			if (entrada.getProducto().equals(producto)) {
				suma += entrada.getCantidad();
			}
		}
		return  suma;
	}
	
	public boolean hayDisponibles(String producto, int cuantosQuiero, List<Inventario> listaInventario) {
		return cuantosDisponibles(producto, listaInventario) >= cuantosQuiero;
	}
	
	public int calcularPrecio(String producto) {
		return calcularPrecio(producto, 1);
	}
	
	public int calcularPrecio(String producto, int cantidad) {
		int precioIndividual = precios.get(producto);
		
		return precioIndividual * cantidad;
	}
	
	public void vender(String producto, int cantidad, List<Inventario> listaInventario) {
		int cuantosQuedanPorSacar = cantidad;

		cuantosQuedanPorSacar = venderParcial(producto, cuantosQuedanPorSacar, TIENDA, listaInventario);
		if (cuantosQuedanPorSacar != 0) {
			venderParcial(producto, cuantosQuedanPorSacar, ALMACEN, listaInventario);
		}		
	}
	
	private int venderParcial(String producto, int cuantosQuedanPorSacar, String donde, List<Inventario> listaInventario){
		for (Inventario entrada: listaInventario) {
			if (entrada.getProducto().equals(producto) &&
					donde.equals(entrada.getLugar())) {
				int losQueSaco;
				int losQueQuedan;
				if (cuantosQuedanPorSacar < entrada.getCantidad()) {
					losQueSaco = cuantosQuedanPorSacar;
					losQueQuedan = entrada.getCantidad() - losQueSaco;
				} else {
					losQueSaco = entrada.getCantidad();
					losQueQuedan = 0;
				}
				entrada.setCantidad(losQueQuedan);
				cuantosQuedanPorSacar -= losQueSaco;
				if (cuantosQuedanPorSacar == 0) {
					return cuantosQuedanPorSacar;
				}
			}
		}
		return cuantosQuedanPorSacar;
	}
}
