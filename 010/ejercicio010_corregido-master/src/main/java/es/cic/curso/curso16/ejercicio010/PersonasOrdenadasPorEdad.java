package es.cic.curso.curso16.ejercicio010;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonasOrdenadasPorEdad implements Ordenable {
	private List<Persona> personas = new ArrayList<>();
	private List<Persona> ordenado = new ArrayList<>();
	
	private Comparable comparador;
	

	public void insertarPersonaSinOrdenar(Collection<Persona> nuevasPersonas) {
		this.personas.clear();
		ordenado.clear();
		
		personas.addAll(nuevasPersonas);
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso16.ejercicio010.Ordenable#ordenar()
	 */
	@Override
	public void ordenar() {
		while (!personas.isEmpty()) {
			int p = 0;
			for (int i= 1; i < personas.size(); i++) {
				int c = comparador.compararPersonas(personas.get(i), personas.get(p));
				if (c >= 0) {
					p = i;
				}
			}
			ordenado.add(0, personas.get(p));
			personas.remove(p);
		}		
	}
	

	public void setComparador(Comparable comparador) {
		this.comparador = comparador;
	}

	public List<Persona> getOrdenado() {
		return ordenado;
	}
	
	
}
