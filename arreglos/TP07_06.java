package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
 * encuentra precargado, solicite al usuario un numero entero y elimine la
 * primer ocurrencia de numero (un número igual) en el arreglo si existe. Para
 * ello tendrá que buscar la posición y si está, realizar un corrimiento a
 * izquierda (queda una copia de la última posición del arreglo en la anteúltima
 * posición).
 */

public class TP07_06 {

	public static int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 0;

	public static void main(String[] args) {

		int[] arrenteros;
		arrenteros = new int[MAX];

		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		try {
			cargar_arreglo_aleatorio_int(arrenteros);
			imprimir_arreglo_int(arrenteros);
			System.out.println("Ingrese un numero :");
			numero = Integer.valueOf(entrada.readLine());
			eliminar_ocurrencia(arrenteros, numero);
			imprimir_arreglo_int(arrenteros);

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void cargar_arreglo_aleatorio_int(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}

	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.println("nombre_arreglo[" + pos + "]=>: " + arr[pos]);
		}
	}

	public static void eliminar_ocurrencia(int[] arr, int numero) {
		for (int pos = 0; pos < MAX; pos++) {
			while (numero == arr[pos]) {
				arr[pos] = arr[pos + 1];
                  
			}
		}
	}
}
