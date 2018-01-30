package es.cic.curso.curso06.ejercicio018.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cine")
public class Cine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	private Long salaId;
	private Long sesionId;
	private int numeroVentas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getSalaId() {
		return salaId;
	}
	public void setSalaId(Long salaId) {
		this.salaId = salaId;
	}
	public Long getSesionId() {
		return sesionId;
	}
	public void setSesionId(Long sesionId) {
		this.sesionId = sesionId;
	}
	public int getNumeroVentas() {
		return numeroVentas;
	}
	public void setNumeroVentas(int numeroVentas) {
		this.numeroVentas = numeroVentas;
	}	
}
