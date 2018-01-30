package es.cic.curso.curso06.ejercicio010.compareTo;

public class PersonaPorEdadComparadorImpl implements PersonaComparador {

	public int comparar (Persona p1, Persona p2) {
		return -(p1.getEdad() - p2.getEdad());
	}

}
