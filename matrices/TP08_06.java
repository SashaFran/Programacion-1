package matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tama?o 5*10 que se encuentra
//precargada, solicite al usuario un numero entero y elimine todas las ocurrencia de numero
//en la matriz si existe. Mientras exista (en cada iteraci?n tiene que buscar la posici?n fila y
//columna) tendr? que usar dicha posici?n para realizar un corrimiento a izquierda.

public abstract class TP08_06 {

	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 0;

	public static void main (String[] args){
		int [][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		carga_matriz(matint);
		System.out.println("Matriz: ");
		imprimir_mat(matint);
		
				BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
				try{
					System.out.println("Ingrese un valor entero: ");
					int valor = Integer.valueOf(entrada.readLine());
					for (int i = 0; i<MAXFILA; i++){
						for (int j=0; j<MAXCOLUMNA; j++){
							if (matint[i][j] == matint[i][valor]){
								corrimiento_izq(matint[i]);
							}
						}
					}
				}catch (Exception exc){
					System.out.println( exc );
		}
		System.out.println("Matriz 2: ");
		imprimir_mat(matint);
		}
		
	public static void corrimiento_izq(int[] matint){
		for (int i = 0; i < MAXCOLUMNA-1; i++) {
				matint[i] = matint[i+1];
			
		}
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
	
}
