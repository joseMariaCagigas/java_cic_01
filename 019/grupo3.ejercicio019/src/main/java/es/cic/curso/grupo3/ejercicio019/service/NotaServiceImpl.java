package es.cic.curso.grupo3.ejercicio019.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo3.ejercicio019.datos.Nota;
import es.cic.curso.grupo3.ejercicio019.datos.Url;
import es.cic.curso.grupo3.ejercicio019.datos.Usuario;
import es.cic.curso.grupo3.ejercicio019.repository.NotaRepository;
import es.cic.curso.grupo3.ejercicio019.repository.UsuarioRepository;

@Service
@Transactional
public class NotaServiceImpl implements NotaService {
	
	@Autowired 
	private NotaRepository notaRepository;

	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Override
	public boolean check (Nota nota){
		boolean resultado = false;
		
		if (!esCheck(nota)){
			nota.setCheck(true);
			resultado = true;
		}
		return resultado;
	}
	
	@Override
	public boolean uncheck (Nota nota){
		boolean resultado = false;
		
		if (esCheck(nota)){
			nota.setCheck(false);
			resultado = true;
		}
		return resultado;
	}
	
	private boolean esCheck (Nota nota){
		boolean resultado = false;
		
		if (nota.isCheck()){
			resultado = true;
		}
		return resultado;
	}
	
	@Override
	public List<Nota> listar(){
		return notaRepository.list();
	}
	
	@Override
	public Nota insertarNota (Usuario usuario,Url url,String texto,boolean check){
		Nota nuevaNota = new Nota();
		nuevaNota.setUsuario(usuario);
		nuevaNota.setUrl(url);
		nuevaNota.setTexto(texto);
		nuevaNota.setCheck(check);
		
		
		return notaRepository.add(nuevaNota);
		
	}	
	@Override
	public Nota insertarNota (Long idUsuario, String texto,boolean check){
		Nota nuevaNota = new Nota();
		nuevaNota.setUsuario(usuarioRepository.read(idUsuario));
		nuevaNota.setTexto(texto);
		nuevaNota.setCheck(check);
		
		
		return notaRepository.add(nuevaNota);
		
	}	
	
}