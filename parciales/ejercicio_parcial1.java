package parciales;
import java.util.Random;


public class ejercicio_parcial1 {

	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAX = MAXFILA * MAXCOLUMNA;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	
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
			System.out.print("\n");
		}
	}
	
	public static void inicializar_arreglo(int [] arr) {
		for (int i = 0; i < MAX; i++) {
			arr[i] = 0;
		}
	}
	
	public static void imprimir_arreglo_int (int [] arr) {
		System.out.print("Arreglo int:\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
	
	public static int final_secuencia(int [] arr, int indice) {
		int pos = indice;
		while ((pos >= 0) && (arr[pos] == 0)) {
			pos--;
		}
		if (pos >= 0)
			return pos;
		else
			return -1;
	}
	
	public static int inicio_secuencia(int [] arr, int indice) {
		int pos = indice;
		while ((pos >= 0) && (arr[pos] != 0)) {
			pos--;
		}
		if (pos >= 0)
			return pos+1;
		else
			return -1;
	}
	
	public static void copiar_secuencia(int [] arrMat, int [] arr, int inicio, int fin, int indice) {
		for (int i = inicio; i <=fin; i++) {
			arr[indice] = arrMat[i];
			indice++;
		}
	}
	
	public static void copiar_ultimas_tres_secuencias(int [][] matriz, int [] arreglo) {
		int indice=0;
		int tamanio;
		for (int fila = 0; fila < MAXFILA; fila++) {
			int inicio = -1;
			int fin = -1;
			int contador = 0;
			fin = final_secuencia(matriz[fila],MAXCOLUMNA-1);
			while (fin != -1) {
				inicio = inicio_secuencia(matriz[fila],fin);
				if (inicio != -1) {
					contador++;
					if (contador < 4) {
						tamanio = fin - inicio + 1;
						copiar_secuencia(matriz[fila],arreglo, inicio, fin, indice);
						indice = indice + tamanio;
					}
				}
				fin = final_secuencia(matriz[fila],inicio - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int [][] matriz = new int [MAXFILA][MAXCOLUMNA];
		int [] arreglo = new int [MAX];
		cargar_matriz_aleatorio(matriz);
		imprimir_matriz(matriz);
		inicializar_arreglo(arreglo);
		copiar_ultimas_tres_secuencias(matriz,arreglo);
		imprimir_arreglo_int(arreglo);
	}
	
}
