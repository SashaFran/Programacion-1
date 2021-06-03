package matrices;

import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, invierta el orden del contenido por fila. Este intercambio no se debe realizar
//de manera explícita, hay que hacer un método que incluya una iteración de intercambio.
public class TP08_01 {
	
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
		invertir_mat(matint);
		System.out.println("Matriz 2: ");
		imprimir_mat(matint);
		}
		
	

	public static void invertir_mat(int[][] matint) {
		int temp;
		for (int i =0; i< MAXFILA/2; i++){
			for (int j=0; j<MAXCOLUMNA; j++){
				temp = matint[i][j];
				int indice = (MAXFILA - i - 1);
				matint[i][j] = matint[indice][j];
				matint[indice][j] = temp;
			}
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
