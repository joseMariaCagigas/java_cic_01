package es.cic.curso.curso06.ejercicio000.comparacion;

public class Persona {
	
	private String nombre;
	private int edad;
	private Color color;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int comparar(Persona p){
		return -(this.getEdad() - p.getEdad());
	}

}
