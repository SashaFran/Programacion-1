//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia con
//el que está en 9, el que está en 1 con el que está en 8...). Este intercambio no se debe realizar
//de manera explícita, hay que hacer un método que incluya una iteración de intercambio.

import java.util.Random;

public class TP07_01 {

	public static int MAX = 10;
	public static int MINV = 0;
	public static int MAXV = 9;
	public static void main(String[] args){
		int [] arr;
		arr = new int[MAX];
		
		carga_arr(arr);
		imprimir_arr(arr);
		division_arr(arr);
		imprimir_arr(arr);
	}
	public static void division_arr(int[] arr) {
		int temp;
		for (int i =0; i< MAX/2; i++){
			temp = arr[i];
			int indice = (MAX - i - 1);
			arr[i] = arr[indice];
			arr[indice] = temp;
		}
		
	}
	public static void imprimir_arr(int[] arr) {
		for (int i = 0; i<MAX; i++){
			System.out.println("Arr["+i+"]=>: " + arr[i]);
		}
		
	}
	public static void carga_arr(int[] arr) {
		Random r = new Random();
		for (int i=0; i< MAX; i++){
			arr[i] = (r.nextInt(MAXV - MINV+1) + MINV);
		}
		
	}
}


