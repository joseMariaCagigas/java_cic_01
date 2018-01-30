package es.cic.curso.curso05.ejercicio017;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FiguraServiceImpl implements FiguraService {
	
	@Autowired
	private FiguraRepository figuraRepository;


	public FiguraServiceImpl(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso05.ejercicio017.FiguraService#listar()
	 */
	@Override
	public List<Figura>  listar(){
		return figuraRepository.list();
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso05.ejercicio017.FiguraService#anadir(es.cic.curso.curso05.ejercicio017.Figura)
	 */
	@Override
	public void anadir(Figura figura){
		figuraRepository.add(figura);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso05.ejercicio017.FiguraService#borrar(es.cic.curso.curso05.ejercicio017.Figura)
	 */
	@Override
	public void borrar(Figura figura){
		figuraRepository.delete(figura);
	}

	
	public FiguraRepository getFiguraRepository() {
		return figuraRepository;
	}

	public void setFiguraRepository(FiguraRepository figuraRepository) {
		this.figuraRepository = figuraRepository;
	}
}
