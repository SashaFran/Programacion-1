package matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
//precargada, solicite al usuario un numero entero y una posición fila, columna. Con estos
//datos tendrá que realizar un corrimiento a derecha (se pierde el último valor en dicha fila)
//y colocar el numero en la matriz en la posición fila, columna indicada.

public class TP08_04 {

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
					System.out.println("Ingrese una pos fila: ");
					int posFil = Integer.valueOf(entrada.readLine());
					System.out.println("Ingrese una pos columna: ");
					int posCol = Integer.valueOf(entrada.readLine());
					System.out.println("Ingrese un valor entero: ");
					int valor = Integer.valueOf(entrada.readLine());
					if ((posFil >= 0)&&(posCol >= 0)&&(valor > 0)){
						if ((posFil < MAXFILA)&&(posCol < MAXCOLUMNA)){
										corrimiento_derecha(matint[posFil], posCol, valor);
									}
								}
				}catch (Exception exc){
					System.out.println( exc );
		}
		System.out.println("Matriz 2: ");
		imprimir_mat(matint);
		}
		
	public static void corrimiento_derecha(int[] matint, int posCol, int valor){
		int indice = MAXCOLUMNA-1;

		for(int i=0; i<MAXCOLUMNA-1; i++){
			matint[indice] = matint[indice-1];
			indice--;
		}
		matint[posCol] = valor;
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
