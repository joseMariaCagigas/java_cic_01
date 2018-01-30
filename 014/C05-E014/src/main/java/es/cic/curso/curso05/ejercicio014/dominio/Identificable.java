package es.cic.curso.curso05.ejercicio014.dominio;

import java.io.Serializable;

public interface Identificable<K> extends Serializable {

	K getId();

	void setId(K id);

}