package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, solicite al usuario un numero entero y elimine la primer ocurrencia de numero (un
//número igual) en el arreglo si existe. Para ello tendrá que buscar la posición y si está, realizar un
//corrimiento a izquierda (queda una copia de la última posición del arreglo en la anteúltima
//posición).
public class TP07_05 {
	public static int MAX = 10;
	public static int MINV = 0;
	public static int MAXV = 9;
	
		public static void main(String[] args){
			int [] arr;
			arr = new int [MAX];
			int valor;
			int pos = 0;
			
			BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
			try{
				
				carga_arr(arr, MAX);
				imprimir_arr(arr, MAX);
				System.out.println("Ingrese un valor: ");
				valor = Integer.valueOf(entrada.readLine());
				if(valor > 0){
					for (int i = 0; i<MAX-1; i++){
						if(arr[i] == arr[i+1]){
							arr[i] = pos;
							System.out.println("i= " + i + " pos: "+ pos);
							corrimiento(MAX, arr, i);
						}
					}
				imprimir_arr(arr, MAX);
				}
			}catch (Exception exc){
				System.out.println( exc );
			}
		}
		public static void corrimiento(int MAX, int[] arr, int pos) {
			for (int i = 0; i < MAX-1; i++) {
				if (arr[i] == arr[pos]) {
					arr[i] = arr[i++];
				}
			}
			
			//falta trasladar el 0 al final.
		}
		public static void imprimir_arr(int[] arr, int MAX) {
			System.out.println("Arreglo: ");
			for (int i = 0; i < MAX; i++){
				System.out.print( arr[i] + "|");
			
		}
			
		}

		public static void carga_arr(int[] arr, int MAX) {
			Random r = new Random();
			for (int i=0; i< MAX; i++){
				arr[i] = (r.nextInt(MAXV - MINV+1) + MINV);
			}
		}
	}
		