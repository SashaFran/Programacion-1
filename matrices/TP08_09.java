package matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado una matriz de enteros de tamaño 4*5 que
//se encuentra precargada, solicite al usuario el ingreso de una fila y dos
//números enteros (columnas de la matriz), y ordene de forma creciente la
//matriz en la fila indicada entre las dos posiciones columnas ingresadas.

public class TP08_09 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 0;

	public static void main (String[] args){
		
		int [][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		
		
		carga_matriz(matint);
		System.out.println("Matriz: ");
		
		imprimir_mat(matint);
		pedida_datos(matint);

		System.out.println("Matriz 2: ");
		imprimir_mat(matint);
		}

	public static void pedida_datos(int[][] matint) {
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
		try{
			System.out.println("Ingrese una fila: ");
			int fila  = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una col  1: ");
			int col1  = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una col  2: ");
			int col2  = Integer.valueOf(entrada.readLine());
			if (col1 < col2){
				if ((fila<MAXFILA)&&(fila>=0)){
					if((col1 < MAXCOLUMNA)&&(col1 >= 0)&&(col2 < MAXCOLUMNA)&&(col2 >= 0)){
						System.out.println("entro 1");
						order_seccion( fila, matint, col1, col2);
					}else{
						System.out.println("El valor no coincide");
					}
						
				}else{
					System.out.println("El valor no coincide");
				}
			}else{
				System.out.println("Ingrese una col  1: ");
				col1  = Integer.valueOf(entrada.readLine());
				System.out.println("Ingrese una col  2 mayor a col 1: ");
				col2  = Integer.valueOf(entrada.readLine());
			}
		}catch (Exception exc){
			System.out.println( exc );
		}
		
	}

	public static void order_seccion(int fila, int[][] matint, int col1, int col2) {
        int posMenor, aux;
        for (int columna = col1; columna <= col2; columna++) {
            posMenor = columna;
            for (int i = columna + 1; i <= col2; i++) {
                if (matint[fila][i] < matint[fila][posMenor]) {
                    posMenor = i;
                }
            }
            if (posMenor != columna) {
                aux = matint[fila][columna];
                matint[fila][columna] = matint[fila][posMenor];
                matint[fila][posMenor] = aux;
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

