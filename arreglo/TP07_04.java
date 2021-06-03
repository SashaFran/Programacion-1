import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, solicite al usuario un numero entero y lo agregue al principio del arreglo (posición
//0). Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor del arreglo) y
//colocar el numero en el arreglo en la posición indicada.
public class TP07_04 {

	public static int MAX = 10;
	public static int MINV = 0;
	public static int MAXV = 9;
	
		public static void main(String[] args){
			int [] arr;
			arr = new int [MAX];
			int pos;
			
			BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
			try{
				carga_arr(arr, MAX);
				imprimir_arr(arr, MAX);
				System.out.println("Ingrese un valor: ");
				pos = Integer.valueOf(entrada.readLine());
				corrimiento(MAX, arr, pos);
				imprimir_arr(arr, MAX);
			}catch (Exception exc){
				System.out.println( exc );
			}
		}
	//Lo que esta en la posicion 0, se copia en int de la posicion
//		public static void corrimiento(int MAX, int[] arr, int pos) {
//		for(int i=0; i<MAX-1; i++){
//			arr[pos] = arr[0];
//			}
//		}
		public static void corrimiento(int MAX, int[] arr, int pos) {
			int indice = MAX-1;

				for(int i=0; i<MAX-1; i++){
					arr[indice] = arr[indice-1];
					indice--;
				}
				arr[0] = pos;
		}
		public static void imprimir_arr(int[] arr, int mAX2) {
			for (int pos = 0; pos < MAX; pos++){
				System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
			
		}
			
		}

		public static void carga_arr(int[] arr, int mAX2) {
			Random r = new Random();
			for (int i=0; i< MAX; i++){
				arr[i] = (r.nextInt(MAXV - MINV+1) + MINV);
			}
		}
	}
		