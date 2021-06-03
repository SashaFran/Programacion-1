package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TP07_17 {

//	public static int MINVALOR = 1;
//	public static int MAXVALOR = 10;
//	public static int MAX = 10;
//
//		
//	public static void main(String[] args) {
//	int[] desordenado = new int[MAX];	
//	int[] ordenado = new int[MAX];	
//	int[] pares = new int[MAX];		
//	int pos, elemento;		
//	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//			
//	try {
//				cargar_arreglo_aleatorio(desordenado);
//				imprimir_arreglo(desordenado);
//				inicializar_arreglo(ordenado);
//				inicializar_arreglo_pares(pares);
//				cargar_arreglo_pares(desordenado, pares);
//				ordenar_arreglo_pares(pares);
//				
//	// Realizar las tareas con arreglos;
//				
//	// a
//				cargar_arreglo_indice_ord(desordenado, ordenado);
//				
//	//imprimir_arreglo(ordenado);
//				imprimir_arreglo(pares);
//				
//	// b
//				System.out.println("Ingrese una posicion menor de un arreglo de tamanio MAX: ");
//
////				pos = Integer.valueOf(entrada.readLine());
//
////				System.out.println("Ingrese un elemento impar entre "+MINVALOR+" y "+(MAXVALOR-1));
//
////				elemento = Integer.valueOf(entrada.readLine());
//
////				if ((elemento>=MINVALOR)&&(elemento<MAXVALOR)&&((elemento%2)!=0)&&(pos>=0)&&(pos<MAX)){
//
////					insertar_elemento_arreglo_pos(desordenado,elemento,pos);
//
////					actualizar_arreglo_ind(ordenado,pos);
//
////					imprimir_arreglo(desordenado);
//
////					imprimir_arreglo(ordenado);
//
////				}
//			
//		} catch (Exception exc) {
//			System.out.println(exc);
//		}
//	}
//
//		
//	//BURBUJA DESCENDENTE
//	private static void ordenar_arreglo_pares(int[] pares) {
//			for (int i = 0; i < MAX; i++) {	
//				for (int j = 0; j < MAX - 1; j++) {
//					if (pares[j] < pares[j + 1]) {
//						int aux = pares[j];
//						pares[j] = pares[j + 1];
//						pares[j + 1] = aux;
//					}
//				}
//			}	
//	}
//		
//	public static void cargar_arreglo_pares(int[] desordenado, int[] pares) {
//			for (int pos = 0; pos < MAX; pos++) {
//				if ((desordenado[pos] % 2) == 0) {
//					pares[pos] = pos;
//				}
//			}
//	}
//
//	public static void inicializar_arreglo_pares(int[] pares) {
//			int valor = -1;
//			for (int i = 0; i < MAX; i++) {
//				pares[i] = valor;
//			}
//	}
//		
//	public static void insertar_elemento_arreglo_pos(int[] original, int elemento, int pos) {
//			corrimiento_der(original, pos);
//			original[pos] = elemento;
//		
//	}
//
//		
}
