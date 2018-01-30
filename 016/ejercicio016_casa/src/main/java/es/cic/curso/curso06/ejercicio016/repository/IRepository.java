package es.cic.curso.curso06.ejercicio016.repository;

import java.util.List;

public interface IRepository<K, T> {
	
	T create(T element);
	T read(K id);
	T update(T element);
	T delete(K id);
	List<T> list();

}
