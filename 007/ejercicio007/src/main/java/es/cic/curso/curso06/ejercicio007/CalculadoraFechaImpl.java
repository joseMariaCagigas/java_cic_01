package es.cic.curso.curso06.ejercicio007;

public class CalculadoraFechaImpl implements CalculadoraFecha {
	private int[] meses = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/* (non-Javadoc)
	 * @see es.cic.curso.curso15.ejercicio007.CalculadoraFecha#diasHastaNavidad(int, int)
	 */
	@Override
	public int diasHastaNavidad(int dia, int mes){

		int totaldias = 0;
		
		if (mes != 12) {
			totaldias += meses[mes-1] - dia;
		}
		
		for (int i = mes; i < meses.length - 1; i ++) {
			totaldias += meses[i];
		}
		
		
		if (mes != 12) {
			totaldias+= 25;
		} else {
			if (dia <= 25) {
				totaldias = 25 - dia;
			} else {
				totaldias = 365 + (25 - dia);
			}
		}
	
		System.out.println("La suma total de los dias hasta Navidad es: " + totaldias);
		
		return totaldias;
	}

}
