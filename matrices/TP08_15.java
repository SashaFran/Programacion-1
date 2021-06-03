package matrices;

import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de caracteres definida y
//precargada elimine todas las secuencias que tienen orden descendente entre
//sus elementos.

public class TP08_15 {
	
	public static final int MAXFILA = 5;
	public static final int MAXCOLUMNA = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.6;
	
	public static void main(String[] args){
		char[][] mat;
		mat = new char[MAXFILA][MAXCOLUMNA];
		
		cargar_matriz_aleatorio_secuencias_char(mat);
		System.out.println("Matriz original: ");
		imprimir_matriz_char(mat);
		
		for (int i=0; i<MAXFILA; i++){
			eliminar_desc(mat[i]);
		}
		System.out.println("Matriz nuevo: ");
		imprimir_matriz_char(mat);
	}
	
	public static void eliminar_desc(char[] mat) {
		int posIni,posFin;
		posIni=0;
		posFin=-1;
		while(posIni<MAXCOLUMNA){
			posIni=obtener_inicio_secuencia(mat,posFin+1);
			if(posIni<MAXCOLUMNA){
				posFin=obtener_fin_secuencia(mat,posIni);
					if (chequeo_desc(mat, posIni, posFin)&&(posIni<posFin)){
						eliminar(mat, posIni, posFin);
					}
				}
			}
		}
	
	
	public static boolean chequeo_desc(char[] mat, int posIni, int posFin) {
		int indice=posIni;
		while((indice<posFin)&&(mat[indice]>mat[indice+1])) {
			indice++;
		}
			if(indice==posFin) 
				return true;
			else
				return false;
	}
	
	public static void eliminar(char[] mat,int posIni, int posFin){
		int indice = posIni;
		while(indice<=posFin) {
			corrimientoIzq(mat,posIni);
			indice++;
		}
		
	}
	
	public static void corrimientoIzq(char[] mat,int posIni){
		for(int i=posIni;i<(MAXCOLUMNA-1);i++) {
			mat[i]=mat[i+1];
		}
	}

	public static int obtener_fin_secuencia(char[] mat, int posIni) {
		while((posIni<MAXCOLUMNA)&&(mat[posIni]!=' ')){
			posIni++;
		}
		return posIni-1;
	}

	public static int obtener_inicio_secuencia(char[] mat, int posFin) {
		while((posFin<MAXCOLUMNA)&&(mat[posFin]==' ')){
			posFin++;
		}
		return posFin;
	}

	//----------------------------------------------------------------------
	
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
}
