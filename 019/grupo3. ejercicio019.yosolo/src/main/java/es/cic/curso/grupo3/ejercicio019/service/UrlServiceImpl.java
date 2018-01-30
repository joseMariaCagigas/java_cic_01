package es.cic.curso.grupo3.ejercicio019.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo3.ejercicio019.datos.Url;
import es.cic.curso.grupo3.ejercicio019.repository.UrlRepository;

@Service
@Transactional
public class UrlServiceImpl implements UrlService {
	
	@Autowired 
	private UrlRepository urlRepository;
	
	@Override
	public Url nueva(String texto){
		Url nuevaUrl = new Url(texto);
		
		urlRepository.add(nuevaUrl);
		
		return nuevaUrl;
	}
	
	@Override
	public boolean modificar(Url url, String texto){
		boolean resultado = false;
		
		if (url.getTexto() != texto){
			url.setTexto(texto);
			resultado = true;
		}
		return resultado;
	}
	
	@Override
	public boolean borrar(Url url){
		boolean resultado = false;
		if (url != null){
			urlRepository.delete(url.getId());
			resultado = true;
		}
		return resultado;
	}
}