package es.cic.curso.curso06.ejercicio016.dto;

import static es.cic.curso.curso06.ejercicio016.dto.TaquillaTYestHelper.imprimir;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.cic.curso.curso06.ejercicio016.dto.Sala;
import es.cic.curso.curso06.ejercicio016.dto.Sesion;
import es.cic.curso.curso06.ejercicio016.files.TaquillaFichero;
import es.cic.curso.curso06.ejercicio016.files.TaquillaFicheroImpl;
import es.cic.curso.curso06.ejercicio016.repository.TaquillaRepositoryImpl;

public class TaquillaFicheroImplTest {
	private TaquillaRepositoryImpl sut;
	private TaquillaFichero cut;
	
	@Before
	public void setUp() throws Exception {
		sut = new TaquillaRepositoryImpl();
		cut = new TaquillaFicheroImpl();
	}

	@Test
	public void testGuardarYcargar() throws IOException {
		List<Sala> salas = sut.listar();
		sut.venderEntradas(100, 0, 0);
		sut.venderEntradas(85, 0, 1);
		sut.venderEntradas(98, 0, 2);
		sut.venderEntradas(50, 1, 0);
		sut.venderEntradas(46, 1, 1);
		sut.venderEntradas(35, 1, 2);
		sut.venderEntradas(26, 2, 0);
		sut.venderEntradas(28, 2, 1);
		sut.venderEntradas(30, 2, 2);
		
		Path p = Files.createTempFile("cine",".txt");
		
		cut.guardar(p.toString(),salas);
		
		List<Sala>salas2 = cut.cargar(p.toString());
		
		for(int i = 0; i < salas.size();i++){
			assertTrue(salas.get(i).equals(salas2.get(i)));
		}
		
		mostrarImprimirSalas(salas2);
	}
	
	
	private void mostrarImprimirSalas(List<Sala>salas){
		List<Sesion> sesiones;
		for(int i = 0; i < salas.size();i++){
			sesiones = salas.get(i).getSesiones();
			for(int j = 0; j < salas.size();j++){
				imprimir("Sala" + (i+1) +": ");
				imprimir("Sesion " + (j+1) +": " + sesiones.get(j).getNumButacas() +
						";" + sesiones.get(j).getButacasOcupadas() + ";" + sesiones.get(j).getButacasLibres());
				
			}
		}
	}

}
