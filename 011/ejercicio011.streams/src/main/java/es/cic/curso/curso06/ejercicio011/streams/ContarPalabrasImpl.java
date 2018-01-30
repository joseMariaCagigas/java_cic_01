package es.cic.curso.curso06.ejercicio011.streams;

import java.io.*;

public class ContarPalabrasImpl implements ContarPalabras {
	
	public void contar(String rutaDe, String rutaHasta) throws IOException{
		
		try(BufferedReader = new BufferedReader(rutaHasta);
				PrintWriter = new PrintWriter(rutaDe);)	{
			
		
				File f_from = new File(rutaDe);
				File f_to = new File(rutaHasta);
				
				if (!f_from.exists()){
			        System.out.println("No existe el fichero de entrada: " + rutaHasta);
			    }else{
			    	String l;
		            while ((l = inputStream.readLine()) != null) {
		                outputStream.println(l);
		            }
			    }
		        
			finally {
		            if (inputStream != null) {
		                inputStream.close();
		            }
		            if (outputStream != null) {
		                outputStream.close();
		            }
		        }
		    
		
	}

}
