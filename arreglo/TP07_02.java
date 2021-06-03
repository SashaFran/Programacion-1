import java.util.Random;

//Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
//precargado, obtenga la cantidad de números pares que tiene y la imprima.

public class TP07_02 {

	public static int MAX = 10;
	public static int MINV = 0;
	public static int MAXV = 9;
	public static void main(String[] args){
		int [] arr;
		arr = new int[MAX];
		
		carga_arr(MAX, arr);
		imprimir_arr(MAX, arr);
		pares_impares(MAX, arr);
	}
	public static void pares_impares(int MAX, int[] arr) {
		int par = 0, impar = 0;
		for (int i= 0; i<MAX; i++){
			if ((arr[i]%2)== 0){
				par++;
			}else if (((arr[i]%3)==0)||((arr[i]%5)==0)||((arr[i]%7)==0)||((arr[i]%1)==0)){
				impar++;
			}else{
				System.out.println("ceros");
			}
		}
		System.out.println("Pares: " + par);
		System.out.println("Impar: " + impar);
	}
	public static void imprimir_arr(int MAX, int[] arr) {
		for (int pos = 0; pos < MAX; pos++){
			System.out.println("nombre_arreglo["+pos+"]=>: "+arr[pos]);
		
	}
	}
	public static void carga_arr(int MAX, int[] arr) {
		Random r = new Random();
		for (int i=0; i< MAX; i++){
			arr[i] = (r.nextInt(MAXV - MINV+1) + MINV);
		}
		
	}
		
	}

