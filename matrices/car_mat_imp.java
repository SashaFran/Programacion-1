package matrices;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class car_mat_imp {

	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 5;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 0;
	public static final double probabilidad_numero = 0.6;
	
	public static void main(String[] args) {
		int [][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		
//	char [][] matchar;
//	double [][] matdouble;
//	matchar = new char[MAXFILA][MAXCOLUMNA];
//	matdouble = new double[MAXFILA][MAXCOLUMNA];
		
	cargar_matriz_int_usuario(matint);
	imprimir_matriz_int(matint);
	cargar_matriz_int_random(matint);
	imprimir_matriz_int(matint);
//	cargar_matriz_aleatorio_char(matchar);
//	cargar_matriz_aleatorio_int(matint);
//	cargar_matriz_aleatorio_double(matdouble);
//	imprimir_matriz_char(matchar);
//	imprimir_matriz_int(matint);
//	imprimir_matriz_double(matdouble);
	
	
	}
	public static void cargar_matriz_int_usuario(int[][] matint){
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
		try{
			for (int i= 0; i<MAXFILA; i++){
				for (int j=0; j<MAXCOLUMNA; j++){
					System.out.println("Ingrese valores");
				matint[i][j] = Integer.valueOf(entrada.readLine());
				}
			}
		}catch (Exception exc){
			System.out.println( exc );
		}
	}
	public static void cargar_matriz_int_random(int[][] matint){
			Random r = new Random();
			for (int i = 0; i < MAXFILA; i++){
				for (int j=0; j< MAXCOLUMNA; j++){
					matint[i][j]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
				}
			}
	}
	
	public static void imprimir_matriz_int(int[][] matint){
			for (int i= 0; i< MAXFILA; i++){
				for (int j=0; j < MAXCOLUMNA; j++){
					System.out.print(matint[i][j] + "|");
				}
				System.out.println();
			}
		}
	
	//---------------------------------------------------------------------------------------------------
	//Carga con secuencia char 
	public static void cargar_arreglo_char(char [] arr){
		Random r = new Random();
		arr[0] = ' ';
		arr[MAXCOLUMNA - 1] = ' ';
		for (int pos = 0; pos < MAXCOLUMNA; pos++){
			if(r.nextDouble()>probabilidad_numero){
				arr[pos]=(char)(r.nextInt(26) + 'a');
			}else{
				arr[pos] = ' ';
			}
		}
	}
	
	public static void cargar_matriz_aleatorio_secuencias_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
		cargar_arreglo_char(mat[fila]);
		}
		System.out.println("");
	}
			
	
	public static void imprimir_matriz_char(char [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
		imprimir_arreglo_char(mat[fila]);
		System.out.println("");
		}
	}
	
	public static void imprimir_arreglo_char(char [] arr){
		for (int pos = 0; pos < MAXCOLUMNA; pos++){
			System.out.print("|"+arr[pos]+"|");
		}
	}
	
	//------------------------------------------------------------------------------------------
	//carga secuencia int
	
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
