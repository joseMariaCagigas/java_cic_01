package es.cic.curso.curso16.ejercicio010;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PersonasOrdenadasPorEdadTest {

	private static final int EDAD_MENOR = 21;

	private static final int EDAD_INTERMEDIOS = 33;

	private static final int EDAD_MAYOR = 45;

	private PersonasOrdenadasPorEdad sut;
	
	private List<Persona> personasAOrdenar;
	
	private Persona mayor, menor;
	
	@Before
	public void setUp() throws Exception {
		sut = new PersonasOrdenadasPorEdad();
		
		sut.setComparador(new PersonaComparable());
		
		personasAOrdenar = new ArrayList<>();
		
		mayor = new Persona(EDAD_MAYOR, "Roberto");
		menor = new Persona(EDAD_MENOR, "Geronimo");
		
		personasAOrdenar.add(new Persona(EDAD_INTERMEDIOS, "Alberto"));
		personasAOrdenar.add(menor);
		personasAOrdenar.add(new Persona(EDAD_INTERMEDIOS, "Pepe"));
		personasAOrdenar.add(mayor);
		
		sut.insertarPersonaSinOrdenar(personasAOrdenar);
	}

	@Test
	public void testOrdenar() {
		
		sut.ordenar();

		List<Persona> resultado = sut.getOrdenado();
		
		assertEquals("El tamaño de la lista ordenada no coincide con la original" , 4, resultado.size());
		assertEquals(resultado.get(0), mayor);
		assertEquals(resultado.get(1).getEdad(), EDAD_INTERMEDIOS);
		assertEquals(resultado.get(2).getEdad(), EDAD_INTERMEDIOS);
		assertEquals(resultado.get(3), menor);
	}

}
