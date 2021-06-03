import java.io.BufferedReader;
import java.io.InputStreamReader;

//Hacer un programa que dado un arreglo ordenado creciente de enteros
//de tamaño 10 que se encuentra precargado, solicite al usuario un numero
//entero y elimine la primer ocurrencia de numero (un número igual) en el
//arreglo si existe.

public class TP07_08 {

	public static int MAX = 10;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 0;

	public static void main(String[] args) {
		
	int[] arrenteros;
	arrenteros = new int[MAX];
	int numero;
		
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		try {
			cargar_arreglo_consola(arrenteros);
			imprimir_arreglo_int(arrenteros);
			System.out.println("Ingrese un numero para reemplazar en la posicion correspondiente : ");
			numero = Integer.valueOf(entrada.readLine());
			int pos=obtener_posicion(arrenteros,numero);
			corrimiento_izq(arrenteros,pos);
			imprimir_arreglo_int(arrenteros);
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void cargar_arreglo_consola(int[] arr) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			for (int i = 0; i < MAX; i++) {
				System.out.println("Ingrese un valor número entero en la posición " + i);
				arr[i] = Integer.valueOf(entrada.readLine());
			}
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void imprimir_arreglo_int(int[] arr) {
		for (int i = 0; i< MAX; i++) {
			System.out.println("nombre_arreglo[" + i + "]=>: " + arr[i]);
		}
	}
	
	public static int obtener_posicion(int[] arr, int numero) {
		int pos = 0;
        while ( arr[pos] != numero) {
        	pos++;
        }
        return pos;
    }
	
	public static void corrimiento_izq(int[] arr, int pos) {
	    int i = pos;
        while (i < MAX - 1) {
            arr[i] = arr[i + 1];
            i++;
        }
	}
}

