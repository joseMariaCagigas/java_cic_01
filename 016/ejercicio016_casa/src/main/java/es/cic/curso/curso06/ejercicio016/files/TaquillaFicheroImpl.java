package es.cic.curso.curso06.ejercicio016.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.cic.curso.curso06.ejercicio016.dto.Sala;
import es.cic.curso.curso06.ejercicio016.dto.Sesion;

public class TaquillaFicheroImpl implements TaquillaFichero {
	
	public TaquillaFicheroImpl(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso05.ejercicio013.TaquillaFichero#guardar(java.lang.String, java.util.List)
	 */
	@Override
	public void guardar(String fichero, List<Sala>salas) throws IOException{
		String salaParaFichero = "";
		try(
			BufferedWriter buffer = new BufferedWriter(new FileWriter(fichero));	
			){
				for(int i = 0; i < salas.size(); i++){
					salaParaFichero = "Sala " + (i+1) + ";";
					List<Sesion>sesiones = salas.get(i).getSesiones();
					int j = 1;
					for(Sesion sesion : sesiones){
						
						salaParaFichero += "Sesion " + j + ";" + sesion.getNumButacas() + ";" + sesion.getButacasOcupadas()
										   + ";" + sesion.getButacasLibres() + ";";
						j++;
					}
					salaParaFichero += "\n";
				    buffer.write(salaParaFichero);
				}
			  }
	}
	
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso05.ejercicio013.TaquillaFichero#cargar(java.lang.String)
	 */
	@Override
	public List<Sala> cargar(String fichero) throws FileNotFoundException, IOException{
		List<Sala>salas = new ArrayList<Sala>();
		try(
			BufferedReader buffer = new BufferedReader(new FileReader(fichero));
			){
				String linea;				
				while((linea = buffer.readLine()) != null){
					String[] entradas = linea.split(";");
					int numSala = Integer.parseInt(entradas[0].substring(5, 6));
					Sala sala = new Sala(numSala);
					int numSesion1 = Integer.parseInt(entradas[1].substring(7, 8));
					int numSesion2 = Integer.parseInt(entradas[5].substring(7, 8));
					int numSesion3 = Integer.parseInt(entradas[9].substring(7, 8));
					int[]numSesiones = {numSesion1,numSesion2,numSesion3};
					
					int numButacas1 = Integer.parseInt(entradas[2]);
					int numButacas2 = Integer.parseInt(entradas[6]);
					int numButacas3 = Integer.parseInt(entradas[10]);
					int[]numButacas = {numButacas1,numButacas2,numButacas3};
					
					int numButacasOcupadas1 = Integer.parseInt(entradas[3]);
					int numButacasOcupadas2 = Integer.parseInt(entradas[7]);
					int numButacasOcupadas3 = Integer.parseInt(entradas[11]);
					int[]numButacasOcupadas = {numButacasOcupadas1,numButacasOcupadas2,numButacasOcupadas3};
					
					sala.getSesiones().clear();
						
					for(int i = 0; i < numSesiones.length;i++){
						Sesion sesion = new Sesion(numButacas[i],numSesiones[i]);
						sesion.setButacasOcupadas(numButacasOcupadas[i]);
						sesion.setButacasLibres(sesion.getButacasOcupadas());
						sala.getSesiones().add(sesion);
					}
					salas.add(sala);
				}
			 }
		return salas;
	}
	
}
