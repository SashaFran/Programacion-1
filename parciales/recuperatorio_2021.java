package parciales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class recuperatorio_2021 {

	final static int MAXFIL = 10;
	final static int MAXCOL = 30;
	
	public static void main(String[] args){
		int mat[][] = new int[MAXFIL][MAXCOL];
		int valor;
		
		try{
			BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
			System.out.println("Ingrese un valor: ");
			valor = Integer.valueOf(entrada.readLine());
			
			if (valor<0){
				recorrerMat(mat, valor);
			}
		}catch(Exception exc){
			System.out.println( exc );
		}
	}
	
	public static void recorrerMat(int[][] mat, int valor) {
		for (int fila=0; fila<MAXFIL; fila++){
			busqueda_secuencial(mat[fila],valor);
		}
	}

	public static void busqueda_secuencial(int arr[], int valor){
		int inicio = 0;
		int fin = 0;
	
		while (inicio<MAXCOL){
			inicio = ini_sec(arr, fin+1);
			if (inicio<MAXCOL){
				fin = fin_sec(arr, inicio);
				int mayorV = mayor_Valor_Par(arr, inicio, fin);
				int suma = suma(arr, inicio, fin); 
					if((suma<valor)&&(promedio(arr, inicio, fin)<mayorV)){
						//Asumiendo que en la consigna habla del mayor numero par (no especifica al final)
						reemplazo(arr, suma, mayorV);
				}
			}
		}
	}
	
	public static void reemplazo(int[] arr, int suma, int pos) {
		for (int i= 0; i<MAXCOL; i++){
			if (i == pos){
				arr[pos] = suma; 
			}
		}
	}

	public static int suma(int[] arr, int inicio, int fin){
		int suma = 0;
		while (inicio<= fin){
			suma+=arr[inicio];
			inicio++;
		}
		return suma;
	}
	
	public static int promedio(int[] arr, int inicio, int fin){
		int suma = 0;	
	    for (int i = inicio; i <= fin; i++)
			suma = suma + arr[i];
	        return suma / (fin - inicio + 1);
	}
	
	public static int mayor_Valor_Par(int[] arr, int inicio, int fin){
		int mayorV = 0;
		
		for (int i=inicio; i<=fin; i++){
			if(arr[i]>arr[i+1]){
				mayorV = i;
			}
		}
		if ((mayorV%2)==0){
			return mayorV;
		}else{
			return -1; //COn esto va a dar error en la condicion de busqueda_central y no va a avanzar.
		}
	}
	
	public static int fin_sec(int[] arr, int pos) {
		while ((pos<MAXCOL)&&(arr[pos] != 0)){
			pos++;
		}
		return pos-1;
	}

	public static int ini_sec(int[] arr, int pos) {
		while ((pos < MAXCOL)&&(arr[pos] == 0)){
			pos++;
		}
		return pos;
	}
}

