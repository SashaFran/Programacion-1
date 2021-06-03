package matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz ordenada creciente por filas de
//enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
//numero entero y una fila, y luego inserte el numero en la matriz en la fila
//indicada manteniendo su orden.

public class TP08_07 {


	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 0;

	public static void main (String[] args){
		int [][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		
		
		carga_matriz(matint);
		ordenar_matriz(matint);
		System.out.println("Matriz: ");
		
		imprimir_mat(matint);
		
				BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
				try{
					System.out.println("Ingrese un valor entero: ");
					int valor = Integer.valueOf(entrada.readLine());
					System.out.println("Ingrese una fila: ");
					int fila  = Integer.valueOf(entrada.readLine());
					
					if (fila<MAXFILA){
									insercion(valor, fila, matint);
								}
						
				}catch (Exception exc){
					System.out.println( exc );
		}
		System.out.println("Matriz 2: ");
		imprimir_mat(matint);
		}
		
	public static void insercion(int valor, int fila, int[][] matint){
		 int pos = buscar_pos(matint, fila, valor);
		 int i = MAXCOLUMNA - 1;
		 while (i > pos){
			 matint[fila][i] = matint[fila][i-1];
			 i--;
		 }
		 matint[fila][pos] = valor;
		}

	public static int buscar_pos(int[][] matint, int fila, int valor) {
		int pos = 0;
		for( int col = 0; col<MAXCOLUMNA; col++){
			if (valor <= matint[fila][col]){
				pos = col;
				break;
			}
		}
		return pos;
	}

	public static void carga_matriz(int[][] matint) {
		Random r = new Random();
		for (int i = 0; i < MAXFILA; i++){
			for (int j=0; j< MAXCOLUMNA; j++){
				matint[i][j]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}
		}
	}

	public static void imprimir_mat(int[][] matint) {

		for (int i= 0; i< MAXFILA; i++){
			for (int j=0; j < MAXCOLUMNA; j++){
				System.out.print(matint[i][j] + "|");
			}
			System.out.println();
		}
	}
	
	public static void ordenar_matriz(int [][] matint) {
		for(int i = 0; i < MAXFILA; i++){
			   for(int j = 0; j < MAXCOLUMNA; j++){
			     for(int k = 0; k < MAXCOLUMNA-1; k++){
			       if(matint[i][k]>matint[i][k+1]){
			            int temp = matint[i][k];
			            matint[i][k] = matint[i][k+1];
			            matint[i][k+1] = temp;
			       }

			     }
			   }
			 }
}
}