package es.cic.curso.curso06.ejercicio016.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sesion")
public class Sesion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="idsala")
	private Long idsala;
	
	@Column(name="turno")
	private int turno;

	@Column(name="numButacas")
	private int numButacas;
	
	@Column(name="butacasOcupadas")
	private int butacasOcupadas;
	@Column(name="butacasLibres")
	private int butacasLibres;
	
	
	public Sesion(){
		super();
	}
	
	public Sesion(Long id, Long idsala, int  numButacas ) {
		super();
		this.id = id;
		this.numButacas = numButacas;
		this.butacasLibres = numButacas;
		this.butacasOcupadas = 0;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getidsala() {
		return idsala;
	}

	public void setidsala(Long idsala) {
		this.idsala = idsala;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getNumButacas() {
		return numButacas;
	}

	public void setNumButacas(int numButacas) {
		this.numButacas = numButacas;
	}

	public int getButacasOcupadas() {
		return butacasOcupadas;
	}

	public void setButacasOcupadas(int butacasOcupadas) {
		this.butacasOcupadas = butacasOcupadas;
	}

	public int getButacasLibres() {
		return butacasLibres;
	}

	public void setButacasLibres(int butacasLibres) {
		this.butacasLibres = butacasLibres;
	}

	



}
