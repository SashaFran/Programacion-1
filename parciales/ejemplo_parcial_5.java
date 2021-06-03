package parciales;

import java.util.Random;

/*
Se tiene una matriz de enteros de tamanio 4*20 de secuencias de numeros entre 1 y 9 (por cada fila), separadas por 0.
La matriz esta precargada, y ademas cada fila empieza y termina con uno o mas separadores 0. Se pide realizar un programa que:
_por cada secuencia con tamanio par, agregue en un arreglo de enteros de tamanio 4*20 inicializado con ceros el promedio entero de la suma de los elementos de la secuencia.
Cada agregado en el arreglo se debe realizar de forma consecutiva de izquierda a derecha y sin separadores.
*/

public class ejemplo_parcial_5 {


	public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static int MAX = 20;
    public static final int MAXVALOR = 10;
    public static final int MINVALOR = 1;
    public static final double probabilidad_numero = 0.4;
	public static void main(String[] args) {
		 int [][] matint =  new int [MAXFILA][MAXCOLUMNA];
		 int[] arrCargarResult = new int[MAX];
		 
	        cargar_matriz_aleatorio_secuencias_int(matint);
	        System.out.println("Matriz original: ");
	        imprimir_matriz_secuencias_int(matint);
	        inicializar_arreglo_ceros(arrCargarResult);
	        segundo_ejercicio(matint,  arrCargarResult);
	        System.out.println("Matriz nueva: ");
	        imprimir_arreglo_secuencias_int(arrCargarResult);

	}
	public static void segundo_ejercicio(int[][] mat, int[] arr) {
    	for (int fila = 0; fila < MAXFILA; fila++) {
    		cal_promedios_secuencias_sumaPar(mat[fila], arr);
        }
    }
	public static void cal_promedios_secuencias_sumaPar(int[] fila,int[] result) {
	    int inicio, fin;
	    inicio = 0;
	    fin = -1;
	   // int suma_secuencia=0;
	    int promedio=0;
	    while ((inicio < MAXCOLUMNA - 1)) {
	        inicio = obtener_inicio_secuencia(fila, fin + 1);
	        if (inicio < MAXCOLUMNA - 1) {
	            fin = obtener_fin_secuencia(fila, inicio);            
	            if (cantidad_par(inicio,fin)) {
	            	promedio=promedio_arreglo(fila, inicio, fin);
	            	agregar_promedio(result, promedio);
	            }
	        }
	    }
	}
	public static void agregar_promedio(int[] arr, int promedio) { // Se modulariza por el hecho de poder guardar de diferentes formas en el arreglo los valores (Por ejemplo podría ser de derecha a izquierda la carga de elementos)
    	int indice = 0;
    	while ((indice < MAX) && (arr[indice] != 0)) { // Busco el primer lugar vacio, debido a que se llena de izquierda a derecha
          indice = indice + 1;
        }
      	if (indice < MAX)
          arr[indice] = promedio;
    }
  
	public static boolean cantidad_par(int inicio_pos, int final_pos) {
    	int cantidad = final_pos - inicio_pos + 1;
      	return cantidad % 2 == 0;
    }
	
	public static int promedio_arreglo(int [] arr, int inicio, int fin){
		int suma = 0;
		for (int pos = 0; pos < MAX; pos++){

		suma+=arr[pos];

		}
		return (suma/MAX);
		}
	public static int obtener_suma_secuencia(int[] arr, int inicio, int fin){
		int suma = 0;
		while (inicio <= fin){
			suma+=arr[inicio];
			inicio++;
		}
		return suma;
	}
	public static int obtener_inicio_secuencia(int[] arr, int pos) {
	    while ((pos < MAXCOLUMNA - 1) && (arr[pos] == 0)) {
	        pos++;
	    }
	    return pos;
	}

	public static int obtener_fin_secuencia(int[] arr, int pos) {
	    while ((pos < MAXCOLUMNA - 1) && (arr[pos] != 0)) {
	        pos++;
	    }
	    return pos - 1;
	}
	
	public static void inicializar_arreglo_ceros(int [] arr){
		for (int pos = 0; pos < MAX; pos++){
			arr[pos]=0;
		}
	}
	public static void imprimir_arreglo_secuencias_int(int[] arr) {
        System.out.print("Arreglo de secuencias int\n|");
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print(arr[pos] + "|");
        }
        System.out.print("\n");
    }

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

	    public static void imprimir_matriz_secuencias_int(int[][] mat) {
	        for (int fila = 0; fila < MAXFILA; fila++) {
	            System.out.print("|");
	            for (int columna = 0; columna < MAXCOLUMNA; columna++) {
	                System.out.print(mat[fila][columna] + "|");
	            }
	            System.out.println("");
	        }
	    }
	
}
