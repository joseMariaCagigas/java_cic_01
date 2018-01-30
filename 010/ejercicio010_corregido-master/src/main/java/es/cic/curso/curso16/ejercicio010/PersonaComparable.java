package es.cic.curso.curso16.ejercicio010;

public class PersonaComparable implements Comparable {

	// TODO Quitar el TODO
	// TODO Refactorizar sacándolo a una clase de comaración
	/* (non-Javadoc)
	 * @see es.cic.curso.curso16.ejercicio010.Comparable#compararPersonas(es.cic.curso.curso16.ejercicio010.Persona, es.cic.curso.curso16.ejercicio010.Persona)
	 */
	@Override
	public int compararPersonas(Persona p1, Persona p2){
		int res = Integer.MAX_VALUE;
		if (p1.getEdad() > p2.getEdad()) {
			res =  -1;
		} else if (p1.getEdad() == p2.getEdad()) {
			res =  0;
		} else {
			res = 1;
		}
		return res;
	}

}
