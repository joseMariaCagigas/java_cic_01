package es.cic.curso.grupo3.ejercicio019.datos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import es.cic.curso.grupo3.ejercicio019.repository.Identificable;

@Entity
@Table(name="NOTA")
public class Nota implements Identificable<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="USUARIO_ID")
	private Long usuarioId;
	
//	@Column(name="URL_ID")
//	private Long urlId;	
	
	@JoinColumn(name="URL_ID")
	@OneToOne(fetch=FetchType.LAZY)
	private Url url;
	
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


	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
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