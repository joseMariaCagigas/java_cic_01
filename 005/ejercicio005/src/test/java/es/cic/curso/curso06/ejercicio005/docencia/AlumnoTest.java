package es.cic.curso.curso06.ejercicio005.docencia;

import static es.cic.curso.curso06.ejercicio005.VariosHelper.imprimir;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.cic.curso.curso06.ejercicio005.docencia.Alumno;
import es.cic.curso.curso06.ejercicio005.docencia.AlumnoBromista;
import es.cic.curso.curso06.ejercicio005.docencia.Persona;
import es.cic.curso.curso06.ejercicio005.docencia.Profesor;

public class AlumnoTest {

	private Alumno sut;
		
	@Before
	public void setUp() throws Exception {
		sut = new Alumno();
		
	}

	@Test
	public void test() {
		sut.taparOidos();
	}
	
	@Test
	public void testPruebas(){
		Persona p;
		Alumno a;
		AlumnoBromista ab;
		Profesor pr;
		
		pr = new Profesor();
		p = new Profesor();
		
		imprimir("Has llegado ")
		
	}

}
