package es.cic.curso.grupo8.ejercicio019.backend.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.Url;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	private UrlRepository urlRepository;
	
	@PersistenceContext
	private EntityManager entityMnager;
	
	/* (non-Javadoc)
	 * @see es.cic.curso.grupo8.ejercicio019.service.UrlService#aniadirUrl(java.lang.String)
	 */
	@Override
	public Long aniadirUrl(String enlace){
		Url url = new Url();
		url.setEnlace(enlace);
		Url aniadida = aniadirUrl(url);
		
		return aniadida.getId();
	}

	private Url aniadirUrl(Url nueva) {
		urlRepository.add(nueva);
		entityMnager.flush();
		
		return nueva;
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.grupo8.ejercicio019.service.UrlService#actualizarUrl(es.cic.curso.grupo8.ejercicio019.dominio.url.Url)
	 */
	@Override
	public Url actualizarUrl(Url modificada){
		return urlRepository.update(modificada);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.grupo8.ejercicio019.service.UrlService#borrarUrl(java.lang.Long)
	 */
	@Override
	public void borrarUrl(Long id){
		
		Url aBorrar = obtenerUrl(id);
		urlRepository.delete(aBorrar);
	}
	
	@Override
	public Url obtenerUrl(Long id){
		
		return urlRepository.read(id);
	}

	@Override
	public List<Url> obtenerUrls() {
		
		return urlRepository.list();
	}
}
