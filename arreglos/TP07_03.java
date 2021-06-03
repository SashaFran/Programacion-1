package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, solicite al usuario una posición y realice un corrimiento a izquierda o hacia la
//menor posición del arreglo.

public class TP07_03 {
	
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
			System.out.println("Ingrese una posicion: ");
			pos = Integer.valueOf(entrada.readLine());
			corrimiento(MAX, arr, pos);
			imprimir_arr(arr, MAX);
		}catch (Exception exc){
			System.out.println( exc );
		}
	}
//Agarro el numero en el pos y lo llevo al final del arreglo.
//	public static void corrimiento(int MAX, int[] arr, int pos) {
//		int aux = arr[pos];
//		for (int i=pos; i<MAX-1; i++){
//			arr[i] = arr[i+1];
//		}
//		arr[MAX-1] = aux;
//	}
	
	public static void corrimiento(int MAX, int[] arr, int pos) {
		for (int i=pos; i<MAX-1; i++){
			arr[i] = arr[i+1];
		}
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
