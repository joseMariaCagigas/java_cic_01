package es.cic.curso.grupo8.ejercicio019.backend.dominio.nota;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import es.cic.curso.grupo8.ejercicio019.backend.Identificable;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.url.Url;
import es.cic.curso.grupo8.ejercicio019.backend.dominio.usuario.Usuario;

@Entity
@Table(name="`nota`")
public class Nota implements Identificable<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1857825032596160853L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
//	@Column(name="id_usuario")
//	private Long idUsuario;
	
	@JoinColumn(name="id_usuario")
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	

	@JoinColumn(name="id_url")
	@OneToOne(fetch=FetchType.LAZY)
	private Url url;
	
	
	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	@Column(name="contenido")
	private String contenido;
	@Column(name="esta_hecho")
	private boolean estaHecho;
	
	@Override
	public Long getId() {
		
		return id;
	}

	@Override
	public void setId(Long id) {
		
		this.id = id;
	}
	
	public String getContenido() {
		
		return contenido;
	}
	
	public void setContenido(String contenido) {
		
		this.contenido = contenido;
	}
	
	public boolean isEstaHecho() {
		
		return estaHecho;
	}
	
	public void setEstaHecho(boolean estaHecho) {
		
		this.estaHecho = estaHecho;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", idUsuario=" + usuario.getId() + ", idURL=" + url.getId() + ", contenido=" + contenido
				+ ", estaHecho=" + estaHecho + "]";
	}
}
