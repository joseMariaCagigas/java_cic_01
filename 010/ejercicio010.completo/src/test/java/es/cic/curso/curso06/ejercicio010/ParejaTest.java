package es.cic.curso.curso06.ejercicio010;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ParejaTest {

	private Pareja sut;
	
	@Before
	public void setUp() throws Exception {
		this.sut = new Pareja();
		sut.setPersonaComparador(new PersonaPorEdadComparadorImpl());
		sut.setPersonasLista(new ArrayList<Persona>());
	}

	@Test
	public void testRecibirPersonas_Edad()
	{
		Persona mayor = new Persona();
		mayor.setEdad(44);
		mayor.setColor(Color.AZUL);
		Persona menor = new Persona();
		menor.setEdad(22);
		menor.setColor(Color.MARRON);
		
		sut.recibirPersonas(menor,mayor);
		
		assertEquals(mayor,sut.getIzquierda());
	}
	
	@Test
	public void testRecibirPersonasLista_Edad()
	{
		//Crea Personas para Poner en la Lista
		Persona p1 = new Persona();
		p1.setEdad(1);
		Persona p2 = new Persona();
		p2.setEdad(5);
		Persona p3 = new Persona();
		p3.setEdad(10);
		Persona p4 = new Persona();
		p4.setEdad(15);
		Persona p5 = new Persona();
		p5.setEdad(20);
		Persona p6 = new Persona();
		p6.setEdad(25);
		Persona p7 = new Persona();
		p7.setEdad(30);
		Persona p8 = new Persona();
		p8.setEdad(40);
		Persona p9 = new Persona();
		p9.setEdad(50);
		Persona p10 = new Persona();
		p10.setEdad(100);
		
		//Aniade de Forma Desordenada las Personas a la Lista
		sut.getPersonasLista().add(p2);
		sut.getPersonasLista().add(p6);
		sut.getPersonasLista().add(p7);
		sut.getPersonasLista().add(p3);
		sut.getPersonasLista().add(p10);
		sut.getPersonasLista().add(p5);
		sut.getPersonasLista().add(p1);
		sut.getPersonasLista().add(p9);
		sut.getPersonasLista().add(p8);
		sut.getPersonasLista().add(p4);
		
		//Llama a 'recibirPersonasLista' y Ordena la Lista
		sut.recibirPersonasLista(sut.getPersonasLista());
		
		//Comprueba que la Lista Está Ordenada
		assertEquals(p1,sut.getPersonasLista().get(9));
		assertEquals(p2,sut.getPersonasLista().get(8));
		assertEquals(p3,sut.getPersonasLista().get(7));
		assertEquals(p4,sut.getPersonasLista().get(6));
		assertEquals(p5,sut.getPersonasLista().get(5));
		assertEquals(p6,sut.getPersonasLista().get(4));
		assertEquals(p7,sut.getPersonasLista().get(3));
		assertEquals(p8,sut.getPersonasLista().get(2));
		assertEquals(p9,sut.getPersonasLista().get(1));
		assertEquals(p10,sut.getPersonasLista().get(0));
	}
}
