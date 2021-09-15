package finales;

	/*Dada una matriz MatA de NxM de secuencias de caracteres separadas por uno o más espacios ‘ ’, realizar un
	programa que ordene ascendentemente toda la matriz de secuencias considerando la cantidad de caracteres
	números que posee cada secuencia. En el caso de requerir corrimientos suponer que siempre hay espacio.
	Observaciones generales:
	_MatA está cargada inicialmente.
	_No se pueden utilizar estructuras auxiliares.
	_Puede haber uno o más caracteres espacio al principio y al final de la fila.
	_Realizar el programa completo bien modularizado.*/

public class Final_libre_2019 {

	final static int MAXF = 5;
	final static int MAXC = 15;
	
	public static void main(String[] args){
		char[][] mat = new char[MAXF][MAXC];
		cargarMat(mat);
		imprimirMat(mat);
		recorrerMat(mat);
		System.out.println("Nueva mat: ");
		imprimirMat(mat);
	}
	
	public static void recorrerMat(char[][] mat){
		for (int fila=0; fila<MAXF; fila++){
			buscarSec(mat[fila]);
		}
	}
	
	public static void buscarSec(char[] arr){
		int inicio = 0, fin = 0;
		
		while (inicio < MAXC){
			inicio = inicioSec(arr, fin + 1);
			if (inicio < MAXC){
				fin = finSec(arr, inicio);
				ordenarSec(arr, inicio, fin);
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
		while ((pos < MAXC)&&(arr[pos]!=' ')){
			pos++;
		}
		return (pos - 1);
	}
	
	public static void cargarMat(char[][] mat){}
	public static void imprimirMat(char[][] mat){}
}
