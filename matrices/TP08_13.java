package matrices;

/*13.Hacer un programa que dada la matriz de secuencias de enteros definida y precargada, y un número entero ingresado por el
 *usuario, elimine de cada fila las secuencias de tamaño igual al número ingresado.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class TP08_13 {

	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	
	public static void main(String[] args) {
		int [][] matInt = new int [MAXFILA] [MAXCOLUMNA];
		int num = 0;
		
		cargar_matriz_aleatorio(matInt);
		imprimir_matriz(matInt);
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Ingrese numero de elementos que debe tener la secuencia a eliminar: ");
			num=Integer.valueOf(entrada.readLine());
		}
		catch (Exception exc) {
			System.out.println(exc);
		}
		borrar_secuencias(matInt,num);
		imprimir_matriz(matInt);
	}
	
	public static int obtener_inicio_secuencia (int [] arr, int indice) {
		int pos = indice;
		while (pos < MAXCOLUMNA && arr[pos] == 0) {
			pos++;
		}
		if (pos < MAXCOLUMNA)
			return pos;
		else
			return -1;
	}
	
	public static int obtener_fin_secuencia (int [] arr, int indice) {
		int pos = indice;
		while (pos < MAXCOLUMNA && arr[pos] != 0) {
			pos++;
		}
		if (pos < MAXCOLUMNA)
			return pos - 1;
		else
			return -1;
	}
	
	public static int obtener_total_elementos (int[] arr, int inicio, int fin) {
		int suma = 0;
		while (inicio <= fin){
			suma++;
			inicio++;
		}
		return suma;
	}
	
	public static void borrar_secuencia (int [] arr, int inicio, int fin) {
		while (inicio <= fin){
			arr[inicio] = 0;
			inicio++;
		}
	}
	
	public static void borrar_secuencias(int [][] matriz, int num) {
		int inicio,fin,total;
		for (int fila = 0; fila < MAXFILA; fila++) {
			inicio=obtener_inicio_secuencia(matriz[fila],0);
			
			while (inicio != -1) {
				fin = obtener_fin_secuencia(matriz[fila],inicio);
				
				if (fin != -1) {
					total=obtener_total_elementos(matriz[fila],inicio,fin);
					
					if (total == num) {
						borrar_secuencia(matriz[fila],inicio,fin);
					}
				}
				inicio = obtener_inicio_secuencia(matriz[fila], fin+1);
			}
		}
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_int (int [] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAXCOLUMNA-1] = 0;
		for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
			if (r.nextDouble()>probabilidad_numero){
				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
			}
			else{
				arr[pos]=0;
			}
		}
	}
	
	public static void cargar_matriz_aleatorio(int [][] matriz) {
		for (int fila = 0; fila < MAXFILA; fila++){
			cargar_arreglo_aleatorio_secuencias_int(matriz[fila]);
		}
	}
	
	public static void imprimir_matriz(int [][] matriz) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			for (int columna = 0; columna < MAXCOLUMNA; columna++) {
				System.out.print("|"+matriz[fila][columna]);
			}
			System.out.println("|");
		}
	}
	
	
	

}

