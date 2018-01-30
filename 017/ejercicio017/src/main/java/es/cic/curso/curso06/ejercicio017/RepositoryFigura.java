package es.cic.curso.curso06.ejercicio017;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryFigura implements RepositoryFiguraImpl {
	
	private static List<Figura> listaFiguras = new ArrayList<>();
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso06.ejercicio017.FiguraRepositoryImpl#agregarFigura(es.cic.curso.curso06.ejercicio017.Figura)
	 */
	@Override
	public void agregarFigura(Figura figura) {
		listaFiguras.add(figura);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso06.ejercicio017.FiguraRepositoryImpl#listarFiguras()
	 */
	@Override
	public List<Figura> listarFiguras() {
		return listaFiguras;
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso06.ejercicio017.FiguraRepositoryImpl#borrarFigura(int)
	 */
	@Override
	public void borrarFigura(int indice) {
		listaFiguras.remove(indice);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso06.ejercicio017.FiguraRepositoryImpl#vaciarLista()
	 */
	@Override
	public List<Figura> vaciarLista() {
		listaFiguras.clear();
		return listaFiguras;
	}

}
