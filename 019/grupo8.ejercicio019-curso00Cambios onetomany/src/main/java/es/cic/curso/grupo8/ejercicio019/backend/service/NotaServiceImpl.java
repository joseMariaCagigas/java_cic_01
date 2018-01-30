package es.cic.curso.grupo8.ejercicio019.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.grupo8.ejercicio019.backend.dominio.nota.Nota;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.nota.NotaRepository;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.Url;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.UrlRepository;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.Usuario;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.UsuarioRepository;

@Service
public class NotaServiceImpl implements NotaService {

	@Autowired
	private NotaRepository notaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	


	@Autowired
	private UrlRepository urlRepository;
	
	@Override
	public Long aniadirNota(Long idUsuario, String contenido) {
		
		Nota nuevaNota = new Nota();
		
		Usuario usuario = usuarioRepository.read(idUsuario);
		
		nuevaNota.setUsuario(usuario);
		nuevaNota.setContenido(contenido);
		
		Nota aniadido = aniadirNota(nuevaNota);
		
		return aniadido.getId();
	}

	@Override
	public Long aniadirNotaConUrl(Long idUsuario, String contenido, Long idURL) {
		
		Nota nuevaNota = new Nota();
		
		Usuario usuario = usuarioRepository.read(idUsuario);
		nuevaNota.setUsuario(usuario);
		nuevaNota.setContenido(contenido);
		
		Url url = urlRepository.read(idURL);
		nuevaNota.setUrl(url);
		
		Nota aniadido = aniadirNota(nuevaNota);
		
		return aniadido.getId();
	}

	private Nota aniadirNota(Nota nuevaNota) {
		notaRepository.add(nuevaNota);
		//entityManager.flush();
		
		return nuevaNota;
	}
	
	@Override
	public Nota obtenerNota(Long id) {
		
		return notaRepository.read(id);
	}

	@Override
	public Nota actualizarNota(Nota notaModificada) {
		
		return notaRepository.update(notaModificada);
	}

	@Override
	public void borrarNota(Long id) {
		
		Nota notaBorrable = obtenerNota(id);
		notaRepository.delete(notaBorrable);
	}

	@Override
	public List<Nota> obtenerNotasUsuario(Long idUsuario) {
		
		List<Nota> listaNotas = notaRepository.list();
		return listaNotas.stream()
				.filter(n -> n.getUsuario().getId() == idUsuario)
				.collect(Collectors.toList());
	}

	@Override
	public List<Nota> obtenerNotas() {
		
		return notaRepository.list();
	}

	public UrlRepository getUrlRepository() {
		return urlRepository;
	}

	public void setUrlRepository(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}

	
	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
}
