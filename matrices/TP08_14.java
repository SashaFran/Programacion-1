package matrices;

import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de caracteres definida y
//precargada, elimine de cada fila todas las ocurrencias de una secuencia
//patrón dada por un arreglo de caracteres de tamaño igual al tamaño de
//columnas de la matriz (solo tiene esa secuencia con separadores al inicio y al
//final). Al eliminar en cada fila se pierden los valores haciendo los corrimientos.

public class TP08_14 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	
	public static void main(String[] args) {
		int [][] matint;
		matint = new int[MAXFILA][MAXCOLUMNA];
		int [] arr={0,1,2,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		cargar_matriz_aleatorio_secuencias_int(matint);
		imprimir_matriz_int(matint);
		System.out.println("ARREGLO PATRON");
		imprimir_arreglo_secuencias_int(arr);
		System.out.println("\n");
		System.out.println("MATRIZ CON SECUENCIAS ELIMINADAS");
		recorrer_filas_matriz(matint,arr);
		imprimir_matriz_int(matint);
		
	}
	
	public static void recorrer_filas_matriz(int[][]matint,int[]arr) {
		for(int i=0;i<MAXFILA;i++)
			buscar_eliminar_secuencias(matint[i],arr);
	}
	
	public static void buscar_eliminar_secuencias(int[]mat,int[]arr) {
		int posIni,posFin;
		int posIniPatron,posFinPatron;
		posIni=0;
		posFin=-1;
		posFinPatron=-1;
		posIniPatron=obtener_inicio_secuencia(arr,posFin+1);
		posFinPatron=obtener_fin_secuencia(arr,posIniPatron);
		while(posIni<MAXCOLUMNA){
			posIni=obtener_inicio_secuencia(mat,posFin+1);
			if(posIni<MAXCOLUMNA)
				posFin=obtener_fin_secuencia(mat,posIni);
			if(sonIguales(mat,arr,posIni,posFin,posIniPatron,posFinPatron)){
				eliminar(mat,posIni,posFin);
				posFin=posIni;
			}
		}
	}
	
	public static void eliminar(int[] mat,int posIni,int posFin){
		int indice=posIni;
		while(indice<=posFin){
			corrimientoIzq(mat,posIni);
			indice++;
		}
	}
	
	public static void corrimientoIzq(int[] mat,int posIni){
		for(int i=posIni;i<(MAXCOLUMNA-1);i++){
			mat[i]=mat[i+1];
		}
		
	}
	
	public static boolean sonIguales(int[] mat,int[]arr,int posIni,int posFin,int posIniPatron,int posFinPatron){
		while((posIni<posFin)&&(posIniPatron<posFinPatron)&&(mat[posIni]==arr[posIniPatron])){
			//guarda con los rangos va hasta una posicion anterior porque en el siguiente if ya se paso
			posIni++;
			posIniPatron++;
		}
		if((posIni==posFin)&&(posIniPatron==posFinPatron)&&(mat[posIni]==arr[posIniPatron]))
			return true;
		else
			return false;
	}
	
	public static int obtener_inicio_secuencia(int[]arr,int pos){
		while((pos<MAXCOLUMNA)&&(arr[pos]==0)){
			pos++;
		}
		return pos;
	}
	
	public static int obtener_fin_secuencia(int[]arr ,int pos){
		while((pos<MAXCOLUMNA)&&(arr[pos]!=0)){
			pos++;
		}
		return pos-1;
	}
	
	public static void cargar_matriz_aleatorio_secuencias_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			cargar_arreglo_aleatorio_secuencias_int(mat[fila]);
		}
		System.out.println("");
	}
	
	public static void imprimir_matriz_int(int [][] mat){
		for (int fila = 0; fila < MAXFILA; fila++){
			imprimir_arreglo_secuencias_int(mat[fila]);
			System.out.println("");
		}
	}
	
	public static void cargar_arreglo_aleatorio_secuencias_int(int [] arr){
		Random r = new Random();
		arr[0] = 0;
		arr[MAXCOLUMNA-1] = 0;
		for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
			if (r.nextDouble()>probabilidad_numero){
				arr[pos]=(r.nextInt(MAXVALOR+MINVALOR-1) + MINVALOR); 
			}
			else{
				arr[pos]=0;				
			}
		}
	}
	
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("|");
		for (int pos = 0; pos < MAXCOLUMNA; pos++){
			System.out.print(arr[pos]+"|");
		}
	}
}


