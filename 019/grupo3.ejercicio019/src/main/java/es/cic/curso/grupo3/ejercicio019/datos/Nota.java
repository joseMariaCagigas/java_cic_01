package es.cic.curso.grupo3.ejercicio019.datos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import es.cic.curso.grupo3.ejercicio019.repository.Identificable;

@Entity
@Table(name="`NOTA`")
public class Nota implements Identificable<Long>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	
	@JoinColumn(name="URL_ID")
	@OneToOne(fetch=FetchType.LAZY)
	private Url url;
	

	@JoinColumn(name="USUARIO_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	

	@Column(name="TEXTO")
	private String texto;
	@Column(name="CHECK")
	private boolean check;	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
}