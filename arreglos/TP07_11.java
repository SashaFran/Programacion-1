package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
	
public class TP07_11 {

		public static final int MAX = 20;
		public static final int MAXVALOR = 9;
		public static final int MINVALOR = 1;
		public static final int MAXPOS = 19;
		public static final int MINPOS = 0;
		public static final double probabilidad_numero = 0.4;

		public static void main(String[] args) {
			int[] arrenteros = new int[MAX];
			int entero = 0;
			int cant = 0;

			cargar_arreglo_aleatorio_secuencias_int(arrenteros);
			imprimir_arreglo_int(arrenteros);
			calcular_mayor_suma(arrenteros);

		}

		public static int ingresar_un_entero(int entero) {
			try {
				BufferedReader entrada = new BufferedReader(new InputStreamReader(
						System.in));
				System.out.println("Ingrese un numero entero :");
				entero = Integer.valueOf(entrada.readLine());
			} catch (Exception exc) {
				System.out.println(exc);
			}
			return entero;
		}

		public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
			Random r = new Random();
			arr[0] = 0;
			arr[MAX - 1] = 0;
			for (int pos = 1; pos < MAX - 1; pos++) {
				if (r.nextDouble() > probabilidad_numero) {
					arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
				} else {
					arr[pos] = 0;
				}
			}
		}

		public static void calcular_mayor_suma(int[] arr) {
			int inicio, fin;
			inicio = 0;
			fin = -1;
			int suma = 0;
			int mayorsuma = 0;
			int iniciomayor = 0;
			int finmayor = 0;
			while (inicio < MAX-1) {
				inicio = obtener_pos_inicio(arr, fin + 1);
				if (inicio < MAX-1) {
					fin = obtener_pos_final(arr, inicio);
					suma = obtener_suma(arr, inicio, fin);
					if (suma > mayorsuma) {
						mayorsuma = suma;
						iniciomayor = inicio;
						finmayor = fin;
					}
				}
			}
			System.out.println("La mayor suma de valores de una secuencia es "+mayorsuma);
		}

				 public static int obtener_suma(int[] arr, int inicio, int fin) {
			        int suma = 0;
			        for (int i = inicio; i <= fin; i++) {
			            suma += arr[i];
			        }
			        return suma;
			    }

		public static int obtener_pos_inicio(int arr[], int pos) {
			while ((pos < MAX) && (arr[pos] == 0)) {
				pos++;
			}
			return pos;
		}

		public static int obtener_pos_final(int arr[], int pos) {
			while ((pos < MAX) && (arr[pos] != 0)) {
				pos++;
			}
			return pos - 1;
		}

		public static void imprimir_arreglo_int(int[] arr) {
			for (int pos = 0; pos < MAX; pos++) {
				System.out.println("arrenteros [" + pos + "]=>: " + arr[pos]);
			}
		}
	}

