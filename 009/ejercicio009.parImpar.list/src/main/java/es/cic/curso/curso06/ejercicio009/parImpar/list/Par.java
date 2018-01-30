package es.cic.curso.curso06.ejercicio009.parImpar.list;

import java.util.ArrayList;
import java.util.List;

public class Par {
	
	List<Integer> par  = new ArrayList<>();
	List<Integer> impar  = new ArrayList<>();
	public void calcular(){
		for (int i = 0; i < 1000; i++){
			if(i%2==0){
				par.add(i);
			}else{
				impar.add(i);
			}
		}
	}
	
	public boolean esPar(int numero){
		if(numero%2==0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean esImpar(int numero){
		if(!(numero%2==0)){
			return true;
		}else{
			return false;
		}
	}
}
