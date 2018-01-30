package es.cic.curso.curso06.ejercicio016.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sala")
public class Sala {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="capacidad")
	private int capacidad;
	
	public Sala(){
		super();
	}
	
	public Sala(Long id, int capacidad) {
		super();
		this.id = id;
		this.capacidad = capacidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	



}
