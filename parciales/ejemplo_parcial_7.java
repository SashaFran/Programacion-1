package parciales;

import java.util.Random;

/*
Se tiene una matriz de enteros de tamanio 4*20 de secuencias de numeros entre 1 y 9 (por cada fila), separadas por 0.
La matriz esta precargada, y ademas cada fila empieza y termina con uno o mas separadores 0. Se pide realizar un programa que:
_para todas las filas inserte al principio de cada secuencia el valor correspondiente a la suma de los valores pares de su contenido
(lo que suman los pares de cada secuencia). Suponer que cada fila de la matriz tiene espacio para agregar esos valores.
*/

public class ejemplo_parcial_7 {

	//generar_matriz_aleatorio
		//imprimir_matriz_aleatorio
			//realizar_segundo_ejercicio()
				//corrimiento derecha
					// buscar pares sumar
			//imprimir_matriz_aleatorio
		public static final int MAXFILA = 4;
		public static final int MAXCOLUMNA = 20;
		public static final int MAXVALOR = 9;
		public static final int MINVALOR = 1;
		public static final int MAX = 9;
		public static final double probabilidad_numero = 0.4;
		public static void main(String[] args) {
			int cantPares = 0; 
			int [][] matint;
			matint = new int[MAXFILA][MAXCOLUMNA];
			cargar_matriz_aleatorio_secuencias_int(matint);
			imprimir_matriz_aleatorio(matint);
			//RESOLVER EL ENUNCIADO DENTRO DEL METODO QUE SIGUE: realizar_segundo_ejercicio(...)
			System.out.println("");
			obtener_suma_pares(matint,cantPares);
			imprimir_matriz_aleatorio(matint);
			
		}
		public static int obtener_suma_pares(int [][] matint, int cantPares){
				int suma =0;
	        	for(int fila = 0 ; fila <MAXFILA; fila++) {
	        		for( int columna = 0; columna< MAXCOLUMNA; columna++) {
	        			if((matint[fila][columna])%2 == 0) {
	        				cantPares++;
	        				suma += cantPares;
	        			}
	        		matint[fila][0]= suma;
	        		}
	        	}
	        	return suma;
	        }
			//EN ESTE METODO DEBE RESOLVER EL ENUNCIADO MODULARIZANDO SEGUN CORRESPONDA
		
		public static void cargar_matriz_aleatorio_secuencias_int(int[][] mat) {
			for (int fila = 0; fila < MAXFILA; fila++) {
	        cargar_arreglo_aleatorio_secuencias_int(mat[fila]);
	    }
		
	    System.out.println("");
	  }
		
		public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
	        Random r = new Random();
	        arr[0] = 0;
	        arr[MAX - 1] = 0;
	        for (int pos = 1; pos < MAX - 1; pos++) {
	            if (r.nextDouble() > probabilidad_numero) {
	                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
	            } else {
	                arr[pos] = 0;
	            }
	        }
	    }
		public static void imprimir_matriz_aleatorio(int[][]matint) {
	    	for(int fila=0; fila<MAXFILA;fila++) {
	    		System.out.print("|");
	    		for (int columna = 0;columna < MAXCOLUMNA; columna++) {
	    			System.out.print(matint[fila][columna]+ "|");
	    		}
	    		System.out.println("");
	    	}
	    }
	
}
