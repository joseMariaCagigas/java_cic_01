package es.cic.curso.grupo8.ejercicio019.backend;

import java.io.Serializable;

public interface Identificable<K> extends Serializable {

	K getId();

	void setId(K id);

}