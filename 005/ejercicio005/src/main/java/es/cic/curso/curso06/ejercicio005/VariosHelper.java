package es.cic.curso.curso06.ejercicio005;

public class VariosHelper {
	
	private static final int NIVEL = 1;

		public static void imprimir(String texto){
			imprimir(NIVEL,texto);
			//System.out.println(texto);
		}
		public static void imprimir(int nivel, String texto){
			if (nivel == NIVEL){
				System.out.println(texto);
			}
			
		}
}
