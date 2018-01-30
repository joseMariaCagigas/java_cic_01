package es.cic.curso.grupo3.ejercicio019.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.grupo3.ejercicio019.datos.Nota;
import es.cic.curso.grupo3.ejercicio019.repository.NotaRepository;

@Service
@Transactional
public class NotaServiceImpl implements NotaService {
	
	@Autowired 
	private NotaRepository notaRepository;

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
	public Nota insertarNota (Long idUsuario, Long idUrl, String texto,boolean isCheck){
		Nota nuevaNota = new Nota(idUsuario, idUrl, texto, isCheck);
		
		return notaRepository.add(nuevaNota);
		
	}	
	
}