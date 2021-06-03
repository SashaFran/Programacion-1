package matrices;

import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, obtenga la cantidad de números pares que tiene y la imprima.

public class TP08_02 {

	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 0;

	public static void main (String[] args){
		int [][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		int cant = 0;
		
		carga_matriz(matint);
		System.out.println("Matriz: ");
		imprimir_mat(matint);
		
		for (int i=0; i<MAXFILA; i++){
			for (int j=0; j<MAXCOLUMNA; j++){
				if (matint[i][j]%2==0){
					cant++;
				}
			}
		}
		System.out.println("Cantidad de numeros pares: " +cant);
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
