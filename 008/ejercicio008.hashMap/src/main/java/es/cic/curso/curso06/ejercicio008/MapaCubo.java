package es.cic.curso.curso06.ejercicio008;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapaCubo implements Cubo {
	private Map<Integer,Long> mapaCubos = new HashMap<>();
	
	public MapaCubo(){
		
	}
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso06.ejercicio008.Cubo#contieneCubo(long)
	 */
	@Override
	public boolean contieneCubo(long posibleCubo){
		return mapaCubos.containsValue(posibleCubo);
		 
	}
	/* (non-Javadoc)
	 * @see es.cic.curso.curso06.ejercicio008.Cubo#contieneCuboDe(long)
	 */
	@Override
	public boolean contieneCuboDe(long clave){
		return mapaCubos.containsKey(clave);
	}
	
	public long sumaClaves(){
		Iterator<Integer> iterador = mapaCubos.keySet().iterator();
		long suma = 0;
		
		while(iterador.hasNext()){
			suma += iterador.next();
		}
		return suma;
	}
}
