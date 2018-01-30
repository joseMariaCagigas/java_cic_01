package es.cic.curso.curso05.ejercicio017;

import java.util.ArrayList;
import java.util.List;


//@Repository
public class FiguraRepositoryImpl implements FiguraRepository {
	
	private List<Figura>figuras;
	
	public FiguraRepositoryImpl(){
		super();
		this.figuras = new ArrayList<>();
	}

	/* (non-Javadoc)
	 * @see es.cic.curso.curso05.ejercicio017.FiguraRepository#add(es.cic.curso.curso05.ejercicio017.Figura)
	 */
	@Override
	public void add(Figura figura) {
		figuras.add(figura);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso05.ejercicio017.FiguraRepository#list()
	 */
	@Override
	public List<Figura> list() {
		return new ArrayList<Figura>(figuras);
	}
	
	
	@Override
	public void delete(Figura figura) {
		figuras.remove(figura);
	}
	
//	public List<Figura> getFiguras() {
//		return figuras;
//	}
//
//	public void setFiguras(List<Figura> figuras) {
//		this.figuras = figuras;
//	}
	
	
}