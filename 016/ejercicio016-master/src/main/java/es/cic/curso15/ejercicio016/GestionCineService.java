package es.cic.curso15.ejercicio016;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionCineService {

	private static final int SESIONES = 3;
	private static final int SALAS = 3;
	private static final int DINERO =5;
	
	private static List<Cine> listaCine= new ArrayList<>();
	
	@Autowired
	private GestionCineRepository gestionCineRepository;
	
	public SalaCine crearSala(){		
		SalaCine sala = new SalaCine();
		List<Sesion> sesionesSala = new ArrayList<>();
		for (int i=0; i<SESIONES; i++){
			Sesion sesion = new Sesion();
			sesion.setIdSesion(i+1);
			sesion.setOcupadas(0);
			sesionesSala = gestionCineRepository.anadirSala(sesion);
			}
		sala.setSesion(sesionesSala);
		return sala;
	}
	
	public Cine crearCine(){	
		Cine cine = new Cine();
		List<SalaCine> salasCine = new ArrayList<>();
		for (int i=0; i<SALAS; i++){
			SalaCine sala = crearSala();
			sala.setIdSala(i+1);
			
			salasCine = gestionCineRepository.insertarNuevoCine(sala);	
		}
		cine.setSalas(salasCine);
		return cine;
	}
	
	public Cine generarAforo(){
		Cine cine = crearCine();
		
		cine.getSalas().get(0).setAforo(100);
		cine.getSalas().get(1).setAforo(50);
		cine.getSalas().get(2).setAforo(30);
		
		return cine;
	}

	public int precioEntradas(int cantidadEntradas){
		return DINERO * cantidadEntradas;
	}
	
	public boolean compruebaVenta(int cantidadEntradas, int sala, int sesion){
		Cine c = generarAforo();
		boolean ventaPosible = false;
		
		for (int i = 0; i < c.getSalas().size(); i++){		//recorremos las salas
			if(c.getSalas().get(i).getIdSala() == sala){	//si el id coincide con la sala
				int aforoSala=c.getSalas().get(i).getAforo();	//damos valor al auxiliar aforo
				for (int j = 0; j < c.getSalas().get(i).getSesion().size(); j++){	//recorremos sesiones
					if(c.getSalas().get(i).getSesion().get(j).getIdSesion() == sesion){	//id sesion == sesion
						int ocupadas = c.getSalas().get(i).getSesion().get(j).getOcupadas();
						if(ocupadas + cantidadEntradas<=aforoSala){
							ventaPosible=true;
						} // 3 if
					}//2 if
				}//segundo for
			}//primer if
		} //primer for
		
		
		listaCine.add(c);
		return ventaPosible;
	}

	public void ventaEntradas(int cantidadEntradas, int sala, int sesion){
		Cine c= listaCine.get(0);
		int ocupadas = c.getSalas().get(sala).getSesion().get(sesion).getOcupadas();
		boolean hayVenta = compruebaVenta(cantidadEntradas, sala, sesion);
		int precio = 0;
		if (hayVenta){
			c.getSalas().get(sala).getSesion().get(sesion).setOcupadas(ocupadas+cantidadEntradas);
			precio = precioEntradas(cantidadEntradas);
		}
		int recaudacion = c.getRecaudacion();
		c.setRecaudacion(recaudacion+precio);
		listaCine.add(c);
	}
	
	public int butacasDisponibles(int sala, int sesion){
		Cine c = listaCine.get(0);
		int aforo = c.getSalas().get(sala).getAforo();
		int ocupadas = c.getSalas().get(sala).getSesion().get(sesion).getOcupadas();
		
		return aforo-ocupadas;
	}
	
	public int recaudacionTotal (){
		Cine c = listaCine.get(0);
		return c.getRecaudacion();
	}
	
	public int recaudacionSala(int sala){
		int recaudacionSala = 0;
		Cine c = listaCine.get(0);
		
		for (int i = 0; i < c.getSalas().size(); i++){		//recorremos las salas
			if(c.getSalas().get(i).getIdSala() == sala){	//si el id coincide con la sala
				recaudacionSala += c.getRecaudacion();
			} //cerramos if
		}	//cerramos for
				
		return recaudacionSala;
	}
	
}
