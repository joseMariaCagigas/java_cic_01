package es.cic.curso.curso17.ejercicio016;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceCine implements ServiceInterface{
	
	
	@Autowired
	private ServiceCine repository;
	
	@Override
	public void abre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int capacidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cambiaEstadoApertura(boolean abierta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaAbierta() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaDisponible(int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cambiaDisponibilidad(int indice, boolean disponibilidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desocupaUnaLocalidad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int localidadesDisponibles() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int localidadesOcupadas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ocupaLocalidadDisponible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregaSesion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desocupaLocalidad(int idSesion, int idLocalidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desocupaLocalidad(int idSesion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaDisponible(int idSesion, int idLocalidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void limpiaSesiones() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int localidadesDisponibles(int idSesion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int localidadesOcupadas(int idSesion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numeroSesiones() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int entradasVendidas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ocupaLocalidad(int idSesion, int idLocalidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ocupaLocalidad(int idSesion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int localidadesDisponibles(int idSala, int idSesion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obtenRecaudacion(int idSala) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obtenRecaudacionTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void vendeEntrada(int idSala, int idSesion, int idLocalidad) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vendeEntrada(int idSala, int idSesion) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vendeEntradas(int idSala, int idSesion, int nEntradas) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public ServiceCine getRepository() {
		return repository;
	}

	public void setRepository(ServiceCine repository) {
		this.repository = repository;
	}

}
