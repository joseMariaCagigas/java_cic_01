package es.cic.curso.curso06.ejercicio018.repositorio;

public interface DAO<K, T> {
	public abstract T crea(T nuevo);
}
