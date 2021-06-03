package parciales;
import java.util.Random;

/*  
Se tiene una matriz de enteros de tamanio 4*20 de secuencias de numeros entre 1 y 9 (por cada fila), separadas por 0.
La matriz esta precargada, y ademas cada fila empieza y termina con uno o mas separadores 0. Se pide realizar un programa que:
_elimine de cada fila todas las secuencias, reemplazando cada secuencia por lo que suma su contenido.
*/

public class ejemplo_parcial_4 {

	    public static final int MAXFILA = 4;
	    public static final int MAXCOLUMNA = 20;
	    public static final int MAXVALOR = 9;
	    public static final int MINVALOR = 1;
	    public static final double PROBABILIDAD_NUMERO = 0.4;

	    public static void main(String[] args) {
	        int[][] matint;
	        matint = new int[MAXFILA][MAXCOLUMNA];
	        cargar_matriz_aleatorio_secuencias_int(matint);
	        System.out.println("Matriz original");
	        mostrarMatriz(matint);
	        realizar_segundo_ejercicio(matint);
	        System.out.println("Matriz resultante");
	        mostrarMatriz(matint);
	    }

	    public static void realizar_segundo_ejercicio(int[][] mat) {
	        for (int fila = 0; fila < MAXFILA; fila++) {
	            int fin = -1;
	            int inicio = encontrar_inicio(mat[fila], fin + 1);
	            int suma = 0;
	            while (inicio < MAXCOLUMNA) {
	                fin = encontrar_fin(mat[fila], inicio);
	                suma = suma_sec(mat[fila], inicio, fin);
	                for (int j = inicio; j < fin; j++) {
	                    corrimiento_izquierda(mat[fila], inicio);
	                    agregar_suma_sec(mat[fila], suma, inicio);
	                }
	                inicio = encontrar_inicio(mat[fila], inicio + 1);

	            }
	        }
	    }

	    public static int suma_sec(int[] arreglo, int inicio, int fin) {
	        if (inicio == fin) {
	            return arreglo[inicio];
	        }
	        int suma = 0;
	        while (inicio <= fin) {
	            suma += arreglo[inicio];
	            inicio++;
	        }
	        return suma;
	    }

	    public static int encontrar_inicio(int[] arreglo, int pos) {
	        while (pos < MAXCOLUMNA && arreglo[pos] == 0) {
	            pos++;
	        }
	        return pos;
	    }

	    public static int encontrar_fin(int[] arreglo, int pos) {
	        while (pos < MAXCOLUMNA && arreglo[pos] != 0) {
	            pos++;
	        }
	        return pos - 1;
	    }

	    public static void corrimiento_izquierda(int[] arreglo, int inicio) {
	        for (int j = inicio; j < MAXCOLUMNA - 1; j++) {
	            arreglo[j] = arreglo[j + 1];
	        }
	    }

	    public static void agregar_suma_sec(int[] arr, int suma, int inicio) {
	        if (inicio < MAXCOLUMNA) {
	            arr[inicio] = suma;
	        }
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
	        arr[MAXCOLUMNA - 1] = 0;
	        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
	            if (r.nextDouble() > PROBABILIDAD_NUMERO) {
	                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
	            } else {
	                arr[pos] = 0;
	            }
	        }
	    }

	    public static void mostrarMatriz(int[][] matriz) {
	        for (int i = 0; i < MAXFILA; i++) { // Recorre las filas
	            for (int j = 0; j < MAXCOLUMNA; j++) { // Recorre las columnas
	                System.out.print("| " + matriz[i][j] + " | ");
	            }
	            System.out.println("");
	        }
	    }
}
