import java.util.Random;
public class parcial4_2021 {
	/*
	Suponer que se tienen dos matrices A y B de secuencias (de caracteres letras minusculas separados por espacios) de tamanio MAXFIL x MAXCOL (cada fila empieza y termina con caracteres espacios), que estan precargadas, y ademas se tiene/n el/los siguiente/s metodo/s (se supone que existe/n y esta/n implementado/s):
	 _un metodo que retorna el indice inicial de la secuencia que tiene mas caracteres repetidos de un arreglo de secuencias (de caracteres letras minusculas separados por espacios) de tamanio MAXCOL (que empieza y termina con espacios).
	 Se pide realizar un programa completo que (sin utilizar arreglos o matrices auxiliares extras a las mencionadas, ni realizar declaraciones explícitas de las matrices):
	_contenga la definicion de el/los encabezado/s de el/los metodo/s mencionado/s como preexistente/s que figura/n en el enunciado (excepto los de carga de datos en matrices, que solamente se invocan).
	_en cada fila de A inserte al final de cada secuencia que tiene al menos una vocal, la secuencia con mas caracteres repetidos que se encuentra de dicha fila en B.

	*/
		public static final int MAXFIL = 4;
		public static final int MAXCOL = 20;
		
//		public static int buscar_indice_inicio_mayor_cantidad_car_repetidos(char [] arr) { // metodo que retorna posicion inicial de la secuencia con mas caracteres repetidos, se dispone}
//		
//		public static boolean tieneVocal(char [] arr, int inicio, int fin) { // metodo para sabes si existe al menos una vocal en la secuencia
//			int cant = 0;
//			for (int i = inicio; i <= fin; i++) {
//				if ((arr[i]== 'a') || (arr[i]== 'e') || (arr[i]== 'i') || (arr[i]== 'o') || (arr[i]== 'u')) {
//					cant++;
//				}
//			}
//			if (cant > 0) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//		
//		public static int obtener_fin_secuencia (char [] arr, int indice) { //metodo para obtener el fin de una secuencia
//			int pos = indice;
//			while (pos < MAXCOL && arr[pos] != ' ') {
//				pos++;
//			}
//			if (pos < MAXCOL)
//				return pos - 1;
//			else
//				return -1;
//		}
//		
//		public static int obtener_inicio_secuencia (char [] arr, int indice) { //metodo para obtener el inicio de una secuencia
//			int pos = indice;
//			while (pos < MAXCOL && arr[pos] == ' ') {
//				pos++;
//			}
//			if (pos < MAXCOL)
//				return pos;
//			else
//				return -1;
//		}
//		
//		//metodo para insertar la secuencia de MATRIZB en MATRIZA con corrimiento a derecha
//		public static void insertar_secuencia_al_final(char [] arrA, char [] arrB, int fin, int inicioB, int finB) { 
//			int indice = MAXCOL - 1;
//			for (int i = inicioB; i <= finB; i++) {
//				while (indice > fin) {
//				arrA[indice] = arrA[indice-1];
//				indice--;
//				}
//				fin++;
//				arrA[indice] = arrB[i];
//			}
//			
//		}
//		
//		public static void buscar_secuencias_con_vocales(char [] arregloA, char [] arregloB) {
//			int inicio,fin;
//			int inicio_arreglo_B = buscar_indice_inicio_mayor_cantidad_car_repetidos(arregloB);
//			int fin_arreglo_B = obtener_fin_secuencia(arregloB,inicio_arreglo_B);
//			int tamanio = fin_arreglo_B - inicio_arreglo_B + 1;
//			inicio = obtener_inicio_secuencia(arregloA,0);
//			while (inicio != -1) {
//				fin = obtener_fin_secuencia(arregloA,fin);
//				if (fin != -1) {
//					if (tieneVocal(arregloA,inicio,fin)) {
//						insertar_secuencia_al_final(arregloA,arregloB,fin,inicio_arreglo_B,fin_arreglo_B);
//						inicio =  obtener_inicio_secuencia(arregloA,fin+tamanio);
//					} else {
//						inicio = obtener_inicio_secuencia(arregloA,fin+1);
//					}
//				}
//			}
//		}
//		
//		public static void insertar_secuencia_mayor_caracteres_repetidos(char [][] matrizA, char [][] matrizB) {
//			for (int fila = 0; fila < MAXFIL; fila++) {
//				buscar_secuencias_con_vocales(matrizA[fila],matrizB[fila]);
//			}
//		}
//		
//		public static void main(String[] args) {
//			char [][] matrizA = new char [MAXFIL] [MAXCOL];
//			char [][] matrizB = new char [MAXFIL] [MAXCOL];
//			cargar_matriz_char_aleatorio(matrizA);
//			cargar_matriz_char_aleatorio(matrizB);
//			insertar_secuencia_mayor_caracteres_repetidos(matrizA,matrizB);
//			imprimir_matriz_char(matrizA);
//		}

	
}
