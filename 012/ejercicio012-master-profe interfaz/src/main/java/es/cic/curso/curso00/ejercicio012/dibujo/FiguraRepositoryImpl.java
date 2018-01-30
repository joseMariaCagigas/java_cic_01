package es.cic.curso.curso00.ejercicio012.dibujo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FiguraRepositoryImpl implements FiguraServicios, FiguraRepositorio {
	
	private static List<Figura> listaFiguras = new ArrayList<>();
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso00.ejercicio012.dibujo.FiguraRepository#nuevo(es.cic.curso.curso00.ejercicio012.dibujo.Figura)
	 */
	@Override
	public void nuevo(Figura figura) {
		listaFiguras.add(figura);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso00.ejercicio012.dibujo.FiguraRepository#listar()
	 */
	@Override
	public List<Figura> listar() {
		return listaFiguras;
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso00.ejercicio012.dibujo.FiguraRepository#borrar(int)
	 */
	@Override
	public void borrar(int indice) {
		listaFiguras.remove(indice);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso00.ejercicio012.dibujo.FiguraRepository#guardar(java.lang.String)
	 */
	@Override
	public void guardar(String fichero) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
			boolean primera = true;
			for(Figura f: listaFiguras) {
				if (!primera) {
					bw.newLine();
				} else {
					primera = false;
				}
				String figuraComoCadena = f.getTamanio() +
												";" + 
										  f.getColor() + 
										  		";" + 
										  f.getTipo() + 
										  		";" + 
										  f.getCentro().getX() +
										  	";" + 
										  f.getCentro().getY();
												
				bw.write(figuraComoCadena);
			}
		}
	}
	
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso00.ejercicio012.dibujo.FiguraRepository#cargar(java.lang.String)
	 */
	@Override
	public void cargar(String fichero) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			String linea;
			listaFiguras.clear();
			while ((linea = br.readLine()) != null) {
				String[] entradas = linea.split(";");
				Figura figura = new Figura();
				figura.setTamanio(Integer.parseInt(entradas[0]));
				figura.setColor(Short.parseShort(entradas[1]));
				figura.setTipo(Byte.parseByte(entradas[2]));
				figura.getCentro().setX(Integer.parseInt(entradas[3]));
				figura.getCentro().setY(Integer.parseInt(entradas[4]));
				listaFiguras.add(figura);
			}

		}
	}	
}
