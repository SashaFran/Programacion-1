package parciales;
import java.util.Random;


public class ejercicio_parcial {

	/*
	 * se tiene una matriz de numeros enteros de tamaño 20x20 q se encuntra
	 * precargada, se pide realizar un programa completo que: _elimine de la matriz
	 * el numero mas grande que tiene, considerendo que no hay numeros repetido.
	 * 
	 */
	public static int MAXFILA = 5;
	public static int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 0;

	public static void main(String[] args) {

		int[][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];

		cargar_matriz_aleatorio_int(matint);
		System.out.println("Matriz original: ");
		imprimir_matriz_int(matint);
		obtener_mayor(matint);
		System.out.println("Matriz nueva: ");
		imprimir_matriz_int(matint);
	}

	public static void cargar_matriz_aleatorio_int(int[][] mat) {
		Random r = new Random();
		for (int fila = 0; fila < MAXFILA; fila++) {
			for (int columna = 0; columna < MAXCOLUMNA; columna++) {
				mat[fila][columna] = (r.nextInt(MAXVALOR + MINVALOR - 1) + MINVALOR);
			}
		}
	}

	public static void imprimir_matriz_int(int[][] mat) {
		for (int i = 0; i < MAXFILA; i++) {
			for (int j = 0; j < MAXCOLUMNA; j++)
				System.out.print("    " + mat[i][j] + "    ");
			System.out.println("");
		}
	}



	public static void obtener_mayor(int[][] mat) {
		int elementoMayor = mat[0][0];
		int posicionFila = 0;
		int posicionColumna = 0;

		for (int i = 0; i < MAXFILA; i++) {
			for (int j = 0; j < MAXCOLUMNA; j++) {
				if (mat[i][j] > elementoMayor) {
					
					elementoMayor = mat[i][j];
					posicionFila = i;
					posicionColumna = j;
					
				}
				corrimiento_izq_fila_columna(mat[i],posicionFila,posicionColumna);
			}
		}
		
		 
          
System.out.println("El elemento mayor es: "+elementoMayor+" la fila en la que se ubica es: "+posicionFila+" y la columna en la que se ubica es: "+posicionColumna);
	}
	
	public static void corrimiento_izq_fila_columna(int[]arr, int posicionFila,int posicionColumna) {
		int indice = 0;
		while(indice < posicionColumna){
			arr[indice] = arr[indice+1];
			indice++;
		}
	}
             

}
