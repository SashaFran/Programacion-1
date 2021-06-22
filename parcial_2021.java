import java.util.Random;


public class parcial_2021 {
//
//	public static final int MAXFIL = 5;
//	public static final int MAXCOL = 10;
//	public static final int MAXVALOR = 9;
//	public static final int MINVALOR = 0;
//	public static final double probabilidad = 0.4;
//	
//	public static void main(String[] args){
//		int [][] A;
//		A = new int[MAXFIL][MAXCOL];
//		int [][] B;
//		B = new int[MAXFIL][MAXCOL];
//		
//		cargar_matriz(A);
//		cargar_matriz(B);
//		
//		System.out.println("Matriz A: ");
//		imprimir_mat(A);
//		
//		System.out.println("Matriz B: ");
//		imprimir_mat(B);
//		
//		suma_sec_por_fila(B, A);
//	}
//	
//
//	public static void suma_sec_por_fila(int[][] A, int[][] B) {
//		for (int fila = 0; fila< MAXFIL; fila++){
//			int ini = 0, fin = -1;
//			while (ini < MAXCOL - 1){
//				int posIni = ini_secuencia_A(A[fila], fin+1);
//				if (ini < MAXCOL -1){
//					int posFin = fin_secuencia_A(A[fila], posIni);
//					int suma = 0;
//					for (int i = posIni; i<=posFin && i<MAXCOL-1; i++){
//					suma+= A[fila][i];
//					}
//						if (((suma%3)==0)&&(suma > 100)){
//							int sec_rep = buscar_secuencias(B[fila]);
//							insercion(sec_rep, A, posFin+1, fila);
//				}
//			}
//			}
//		}
//	}
//
//
//	private static int fin_secuencia_A(int[] A, int pos) {
//		while((pos < MAXCOL )&& (A[pos] != 0)){
//			pos++;
//		}
//		return pos-1;
//	}
//
//
//	private static int ini_secuencia_A(int[] A, int pos) {
//		while ((pos<MAXCOL)&&(A[pos]== 0)){
//			pos++;
//		}
//		return pos;
//	}
//
//
//	public static void insercion(int sec_rep, int[][] mat, int pos, int fila) {
//		int i = MAXCOL -1;
//		while (i > pos){
//			mat[fila][i] = mat[fila][i-1];
//			i--;
//		}
//		mat[fila][pos] = sec_rep;
//}
//	//----------------------------------------------------------------------
//
//	private static int buscar_secuencias(int[] arr) {
//		int posIni = 0, posFin = -1;
//		int cantIg = 0;
//		while(posIni<MAXCOL){
//			posIni = ini_secuencia_B(arr, posFin+1);
//			if (posIni<MAXCOL)
//				posFin =fin_secuencia_B(arr, posIni);
//			if(sec_iguales(arr, posIni, posFin) >= 1){
//				cantIg++;
//			}
//		}
//		return cantIg;
//	}
}
