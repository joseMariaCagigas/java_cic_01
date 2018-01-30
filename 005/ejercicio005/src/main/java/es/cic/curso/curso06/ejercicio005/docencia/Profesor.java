package es.cic.curso.curso06.ejercicio005.docencia;

import static es.cic.curso.curso06.ejercicio005.VariosHelper.imprimir;

public class Profesor extends Persona {
	
	public void gritar(String mensaje){
		imprimir(mensaje);
		setGafas(false);
	}
	
	public boolean isGafas() {
		return gafas;
	}

	public void setGafas(boolean gafas) {
		this.gafas = gafas;
	}

	private boolean gafas;
	
	public Profesor(){
		imprimir("El profesor se quita las gafas");
		this.gafas = false;
	}
	
	
}
