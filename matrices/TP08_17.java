package matrices;

import java.util.Random;

//  Para el Ejemplo 10, hacer:
//   – cargar un arreglo ARR_SUMAS_COLUMNAS_PARES los índices de las columnas de MAT cuya suma es par (-1 para completar si no hay).
//   – ordenar ARR_SUMAS_COLUMNAS_PARES de forma ascendente según las sumas de columnas de MAT utilizando un método de ordenamiento.

public class TP08_17 {

	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	public static void main(String[] args) {
		int [][] mat;                  
		int [] arr_suma_filas_ord;                  
		mat = new int[MAXFILA][MAXCOLUMNA];                  
		arr_suma_filas_ord = new int[MAXFILA];                  
		cargar_matriz_aleatorio_int(mat);
		System.out.println("Matriz: ");
		imprimir_matriz_int(mat);
		cargar_indices_filas_arreglo(arr_suma_filas_ord);
		System.out.println("");
		ordenar_arreglo_indice_seleccion(mat,arr_suma_filas_ord);
		System.out.println("Orden de sumas: ");
		imprimir_arreglo(arr_suma_filas_ord);		
	}

	public static void cargar_indices_filas_arreglo(int [] arr){
		for (int fila = 0; fila < MAXFILA; fila++){
			arr[fila] = fila;
		}
	}

	public static int obtener_suma_fila(int [] arr){
		int suma = 0;
		for (int columna = 0; columna < MAXCOLUMNA; columna++){
			suma += arr[columna];
		}
		return suma;
	}
	
	
	public static void ordenar_arreglo_indice_seleccion(int[][] original, int arr[]) {
		int pos_menor, tmp;
		int i, j;
		i = 0;
		int impar = -1;
		while (i < MAXFILA) { 
			pos_menor = i;
			j = i + 1;
			while (j < MAXFILA){ 	
				if(obtener_suma_fila(original[arr[j]])%2==0){
					if ((obtener_suma_fila(original[arr[j]]) < obtener_suma_fila(original[arr[pos_menor]]))){
						pos_menor = j;
					}
				}else{
					pos_menor = impar;
				}
				j++;
			}
			if (pos_menor != i){
				tmp = arr[i];
				arr[i] = arr[pos_menor];
				arr[pos_menor] = tmp;
			}
			i++;
		}
	}		
	
//	---------------------------------------------------------------------------------------------------
	
	public static void imprimir_arreglo(int [] arr){
		for (int pos = 0; pos < MAXFILA; pos++){
			System.out.print("|"+arr[pos]+"|");
		}   
	} 
	
	public static void cargar_matriz_aleatorio_int(int [][] mat){
		Random r = new Random();
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				mat[fila][columna]=(r.nextInt(MAXVALOR+MINVALOR-1) + MINVALOR);
			}
		}
	}

	public static void imprimir_matriz_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			for (int columna = 0; columna < MAXCOLUMNA; columna++){
				System.out.print("| "+mat[fila][columna]+" |");
			}
			System.out.println("");
		}
	}
}
