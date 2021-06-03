package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/* Hacer un programa que dada la matriz de secuencias de enteros definida y
 * precargada, y un número entero ingresado por el usuario, elimine de cada fila
 * las secuencias de tamaño igual al número ingresado.
 */

public class TP07_13 {


	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;

	public static final double probabilidad_letra = 0.4;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {

		int[][] matint;

		matint = new int[MAXFILA][MAXCOLUMNA];
		int usuario, fila;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			cargar_matriz_aleatorio_secuencias_int(matint);
			imprimir_matriz_int(matint);
			System.out.println("Ingrese un numero :");

			usuario = Integer.valueOf(entrada.readLine());

			imprimir_secuencias_tamaño_distinto_matriz(matint, usuario);

			imprimir_matriz_int(matint);

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void imprimir_secuencias_tamaño_distinto_matriz(int[][] matint, int usuario) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			
			comparar_tamaño_de_cada_secuencia(matint[fila], usuario);
		}
	}

	public static void comparar_tamaño_de_cada_secuencia(int[] arr, int usuario) {
		int inicio, fin, tamaño;
		inicio = 0;
		fin = -1;
		while (inicio < MAXCOLUMNA) {
			inicio = obtener_inicio_secuencia(arr, fin + 1); // REUTILIZAMOS
			if (inicio < MAXCOLUMNA) {
				fin = obtener_fin_secuencia(arr, inicio); // REUTILIZAMOS
				tamaño = fin - inicio + 1;
				if (tamaño == usuario) {
					for (int i = inicio; i <= fin; i++) {
						arr[i] = 0;
					}

				}
			}
		}
		
	}

	public static int obtener_inicio_secuencia(int[] arr, int fin) {
		int inicio = fin;

		while (arr[inicio] == 0 && inicio < MAXCOLUMNA) {
			inicio++;
			if (inicio == MAXCOLUMNA) {
				return MAXCOLUMNA;
			}
		}
		return inicio;

	}

	public static int obtener_fin_secuencia(int[] arr, int inicio) {

		int fin = inicio;

		while (arr[fin] != 0 && fin < MAXCOLUMNA) {
			fin++;
		}
		return fin - 1;
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
			if (r.nextDouble() > probabilidad_numero) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimir_matriz_int(int[][] mat) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			imprimir_arreglo_secuencias_int(mat[fila]);
			System.out.println("");
		}
	}

	public static void imprimir_arreglo_secuencias_int(int[] arr) {

		for (int pos = 0; pos < MAXCOLUMNA; pos++) {
			System.out.print(arr[pos] + "|");
		}
	}
}
