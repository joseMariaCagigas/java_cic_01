package es.cic.curso.curso06.ejercicio006;

public class CalculadoraFechas {

	int diasAnio = 365;
	
	private int[] anio = new int [] {31,28,31,30,31,30,30,31,30,31,30,31};
	
	
	public void calcularDia(int dia, int mes){
	
		int totaldias = 0;
		
		if(mes != 12){
			totaldias += 
		}
		
		for(int i = mes; i < anio.length - 1; i++){
			totaldias += anio[i];
		}
		if(mes!=12){
			totaldias+= 25;
		}else{
			if(dia<= 25){
				totaldias = 25 - dia;
			}else{
				totaldias = 365 + (25-dia);
			}
		}

	}
}
