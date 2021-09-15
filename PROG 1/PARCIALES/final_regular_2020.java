package finales;

import java.util.Random;

	/*Dado un arreglo ARR de tamaño N de secuencias de enteros separadas por uno o más ceros, hacer un programa que
	extraiga todas las secuencias con cantidad par de elementos y las copie en un arreglo PAR de enteros de tamaño N
	(quedando separadas por un 0).
	Observaciones generales:
	_ARR está cargado inicialmente y PAR está inicializado con ceros.
	_No se pueden utilizar estructuras auxiliares.
	_Puede haber uno o más ceros al principio y al final del arreglo.
	_Realizar el programa completo bien modularizado.*/
public class final_regular_2020 {
	
	final static int N = 20;
	static final int MINVALOR = 1;
	static final int MAXVALOR = 9;
	static final Double probabilidad_numero = 0.6;
	
	public static void main(String[] args){
		int[] arr = new int[N];
		int[] par = new int[N];
		cargaArr(arr);
		imprimirArr(arr);
		recorrerArr(arr, par);
		System.out.println("nuevo arreglo");
		imprimirArr(par);
	}
	
	public static void recorrerArr(int[] arr, int[] par){
		int inicio = 0, fin = 0;
		int tamaño = 0;
		
		while (inicio < N){
			inicio = inicioSec(arr, fin + 1);
			if (inicio < N){
				fin = finSec(arr, inicio);
				tamaño = (fin - inicio + 1);
				if ((tamaño % 2)==0){
					for (int i=inicio; i<=fin; i++){
						par[i] = arr[i];
					}
				}
			}
		}
	}
	
	public static int inicioSec(int[] arr, int pos){
		while ((pos < N)&&(arr[pos] == 0)){
			pos++;
		}
		return pos;
	}
	
	public static int finSec(int[] arr, int pos){
		while ((pos < N)&&(arr[pos]!=0)){
			pos++;
		}
		
		return pos - 1 ;
	}
	
	public static void cargaArr(int[] arr){
		Random r = new Random();
		arr[0] = 0;
		arr[N-1] = 0;
		for (int pos = 1; pos < N-1; pos++){
			if (r.nextDouble()>probabilidad_numero){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}
			else{
				arr[pos]=0;
			}
		}
	}
	
	public static void imprimirArr(int[] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < N; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}

}
