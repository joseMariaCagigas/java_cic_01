package es.cic.curso.curso06.ejercicio010;

public class VariosHelper
{
	private static final int NIVEL = 1;
	
	private VariosHelper(){}
	
	public static void imprimir (String texto)
	{
		imprimir(NIVEL,texto);
	}
	
	public static void imprimir (int nivel, String texto)
	{
		if (nivel == NIVEL){
			System.out.println(texto);
		}
	}
}
