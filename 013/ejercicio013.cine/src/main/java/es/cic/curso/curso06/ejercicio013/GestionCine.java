package es.cic.curso.curso06.ejercicio013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionCine {

	private List<Sala> salas;
	private List<Sesion> sesiones;
	private List<Entrada> entradasVendidas;
	private static final int precio = 5;
	
	public GestionCine(){
		
		super();
		salas = new ArrayList<>();
		salas.add(new Sala(1,100));
		salas.add(new Sala(2,50));
		salas.add(new Sala(3,30));
	}
	
	public void cierreSesion (int nroSesion) {
		for(int i=0;i<salas.size();i++)
		{
			salas.get(i).getSesiones().get(nroSesion -1).setButacasDisp(0);
		}
	}
	
	public void cierreSala (int nroSala) {
		Sala s= salas.get(nroSala - 1);
		for(int i=0;i<s.getSesiones().size();i++)
		{
			s.getSesiones().get(i).setButacasDisp(0);
		}
	}
	
	
	public void abrirSala (int nroSala) {
		Sala s= salas.get(nroSala - 1);
		for(int i=0;i<s.getSesiones().size();i++)
		{
			s.getSesiones().get(i).setButacasDisp(s.getButacasTotales());
		}
	}
	
	
	
	
	public GestionCine(List<Sala> salas, List<Sesion> sesiones, List<Entrada> entradasVendidas) {
		super();
		
		this.salas = salas;
		this.sesiones = sesiones;
	//	this.entradasVendidas = entradasVendidas;
	}
	
	public int consultarEntradas(Sesion sesionEntradas){
		return sesionEntradas.getButacasDisp();
	}
	
	public int PrecioEntradas(int numEntradas, Sesion sesionEntradas){
		int importe=0;

		if(consultarEntradas(sesionEntradas)>=numEntradas){
			importe = numEntradas * precio;
		}
		return importe;
	}
	

	public int venderEntradas(int numEntradas, int nroSala, int nroSesion)	{
		int butacasDisponibles = salas.get(nroSala - 1).getSesiones().get(nroSesion -1).getButacasDisp() ;
		if( butacasDisponibles >=numEntradas){
			butacasDisponibles = butacasDisponibles - numEntradas;
			salas.get(nroSala - 1).getSesiones().get(nroSesion -1).setButacasDisp(butacasDisponibles);
		}
		else {
			return 0;
		}		
		return numEntradas;
	}
	
	
	public double costevenderEntradas(int numEntradas, int nroSala, int nroSesion)	{
		double coste = 0;
		int butacasDisponibles = salas.get(nroSala - 1).getSesiones().get(nroSesion -1).getButacasDisp() ;
		if( butacasDisponibles >=numEntradas){
			butacasDisponibles = butacasDisponibles - numEntradas;
			salas.get(nroSala - 1).getSesiones().get(nroSesion -1).setButacasDisp(butacasDisponibles);
			coste = 	numEntradas * precio;
			if (numEntradas >= 5){
				double descuento = 0.10 ;
				double valorDescuento = coste * descuento ;
				coste = coste - valorDescuento;
			}
		} 
		else {
			return 0;
		}		
		return coste;
	}
	
	public int devolverEntradas(int numEntradas, int nroSala, int nroSesion)	{
		int butacasDisponibles = salas.get(nroSala - 1).getSesiones().get(nroSesion -1).getButacasDisp() ;
		int butacasTotales = salas.get(nroSala - 1).getButacasTotales();
		int entradasVendidas = butacasTotales - butacasDisponibles;
		
		if( numEntradas <= entradasVendidas){
			butacasDisponibles = butacasDisponibles + numEntradas;
			salas.get(nroSala - 1).getSesiones().get(nroSesion -1).setButacasDisp(butacasDisponibles);
		}
		else {
			return 0;
		}		
		return numEntradas;
	}
	public int totalEntradasVendidas(){
		
		int total = 0;
		
		for(int i=0;i<salas.size();i++)
		{
			total = total + entradasvendidasporsala(salas.get(i)); 
		}

		return total;
	}
 	
	private int  entradasvendidasporsala (Sala s){
		int cantidadvendida = 0;
		int totalButacas = s.getButacasTotales();
		int butacasVendidas = 0;
		for(int i=0;i<s.getSesiones().size();i++)
		{
			butacasVendidas = totalButacas - s.getSesiones().get(i).getButacasDisp();
			cantidadvendida = cantidadvendida +  butacasVendidas;
		}
		
		return cantidadvendida;
	}
	
	
	
	
	public void grabarTotalEntradas() throws  IOException{
			String fichero = null;
			try(BufferedWriter br = new BufferedWriter(new FileWriter(fichero))) {
				int tot =totalEntradasVendidas();
			br.write(String.valueOf(tot));
			
			}
			catch (IOException e)
			{
				
			}
	}

	public List<String> leeFichero() throws  IOException{
		String fichero = null;
		List<String> productosFichero = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			
			StringBuilder sb = new StringBuilder();
			String linea = br.readLine();

			while (linea != null) {
				sb.append(linea);
				productosFichero.add(linea);
				linea = br.readLine();
			}
			return productosFichero;
		}
	}
	
	
	
	
	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

	public List<Entrada> getEntradasVendidas() {
		return entradasVendidas;
	}

	public void setEntradasVendidas(List<Entrada> entradasVendidas) {
		this.entradasVendidas = entradasVendidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entradasVendidas == null) ? 0 : entradasVendidas.hashCode());
		result = prime * result + ((salas == null) ? 0 : salas.hashCode());
		result = prime * result + ((sesiones == null) ? 0 : sesiones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GestionCine other = (GestionCine) obj;
		if (entradasVendidas == null) {
			if (other.entradasVendidas != null)
				return false;
		} else if (!entradasVendidas.equals(other.entradasVendidas))
			return false;
		if (salas == null) {
			if (other.salas != null)
				return false;
		} else if (!salas.equals(other.salas))
			return false;
		if (sesiones == null) {
			if (other.sesiones != null)
				return false;
		} else if (!sesiones.equals(other.sesiones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GestionCine [salas=" + salas + ", sesiones=" + sesiones + ", entradasVendidas=" + entradasVendidas
				+ "]";
	}
	
	
}
