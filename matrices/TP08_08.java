package matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz ordenada creciente por filas de
//enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
//numero entero y una fila, y elimine la primer ocurrencia de numero en la
//fila indicada (un número igual) si existe.

public class TP08_08 {

	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
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
					
					if ((fila<MAXFILA)&&(fila>=0)){
						for (int i=0; i<MAXFILA; i++){
							for (int j=0; j<MAXCOLUMNA; j++){
								if (matint[fila][j] == valor){
									eliminar_ocu(valor, fila, matint);
								}else{
									System.out.println("No existe el valor");
								}
							}
						}
									
								}
						
				}catch (Exception exc){
					System.out.println( exc );
		}
		System.out.println("Matriz 2: ");
		imprimir_mat(matint);
		}
		
	public static void eliminar_ocu(int valor, int fila, int[][] matint){
		 int pos = buscar_pos(matint, fila, valor);
		    int i = pos;
	        while (i < MAXCOLUMNA - 1) {
	            matint[fila][i] = matint[fila][i + 1];
	            i++;
		}
	}
	public static int buscar_pos(int[][] matint, int fila, int valor) {
		int pos = 0;
		for( int col = 0; col<MAXCOLUMNA; col++){
			if(matint[fila][col] == valor){
				pos = col;
				System.out.println("pos: "+pos);
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

