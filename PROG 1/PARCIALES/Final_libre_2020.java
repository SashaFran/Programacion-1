package finales;

import java.util.Random;
	/*Dada una matriz MatA de NxM de secuencias de caracteres separadas por uno o más espacios ‘ ’, realizar un
	programa que ordene ascendentemente toda la matriz de secuencias considerando el orden alfabético entre
	secuencias. En el caso de requerir corrimientos suponer que siempre hay espacio.
	Observaciones generales:
	_MatA está cargada inicialmente, donde las secuencias solo tienen caracteres letras.
	_No se pueden utilizar estructuras auxiliares.
	_Puede haber uno o más caracteres espacio al principio y al final de la fila.
	_Realizar el programa completo bien modularizado..*/
public class Final_libre_2020 {

	final static int MAXC = 15;
	final static int MAXF = 5;
	private static final double probabilidad_letra = 0.6;
	
	public static void main (String[] args){
		char[][] MAT = new char[MAXF][MAXC];
		cargarMat(MAT);
		imprimirMat(MAT);
		recorrerMat(MAT);
		System.out.println("Nueva mat:" );
		imprimirMat(MAT);
	}
	
	public static void recorrerMat(char[][] mat){
		for (int fila=0; fila<MAXF; fila++){
			buscarSec(mat[fila]);
		}
	}
	
	public static void buscarSec(char[] arr){
		int inicio=0;
		int fin=0;
		
		while(inicio<MAXC){
			inicio = inicioSec(arr, fin +1);
			if (inicio < MAXC){
				fin = finSec(arr, inicio);
				//for (int i=inicio; i<=fin; i++){
					ordenarSec(arr, inicio, fin);
				//}
			}
		}
	}
	
	public static void ordenarSec(char[] arr, int inicio, int fin){
		char temp;
		for (int i=0; i <=fin; i++){
			for (int j=inicio; j<=fin-1; j++){
				if (arr[j]> arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static int inicioSec(char[] arr, int pos){
		while ((pos < MAXC)&&(arr[pos]==' ')){
			pos++;
		}
		return pos;
	}
	
	public static int finSec(char[] arr, int pos){
		while ((pos < MAXC)&&(arr[pos] != ' ')){
			pos++;
		}
		return pos-1;
	}	
	
	public static void imprimirMat(char[][] mat){
		for (int fila = 0; fila < MAXF; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXC; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
		}
	}
	
	public static void cargarMat(char[][] mat){
		for (int fila = 0; fila < MAXF; fila++){
			cargar_arreglo_aleatorio_secuencias_char(mat[fila]);
		}
		System.out.println("");
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_char(char [] arr){
		Random r = new Random();
		arr[0] = ' ';
		arr[MAXC-1] = ' ';
		for (int pos = 1; pos < MAXC-1; pos++){
			if (r.nextDouble()>probabilidad_letra){
				arr[pos]=(char)(r.nextInt(26) + 'a');
			}
			else{
				arr[pos]=' ';				
			}
		}
	}
}

	
