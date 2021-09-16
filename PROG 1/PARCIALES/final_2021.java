import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class final_2021 {
/*	Sea una matriz de enteros de secuencias de números entre 1 y 9 (por cada fila), separadas por ceros. La matriz está precargada (no implementar el método de carga), y además cada fila empieza y termina con uno o más separadores 0. Se pide realizar un programa que:
		_dado un numero ingresado por el usuario, por cada secuencia que tiene solo dos números iguales al ingresado, reemplace el mayor valor que posee por lo que suma el contenido de la secuencia. 
*/

		    final static int MAXF = 3;
		    final static int MAXC = 5;
		    final static int MINVALOR = 1;
		    final static int MAXVALOR = 9;
		    final static Double probabilidad_numero = 0.1;

		    public static void main(String[] args){
		        int[][] mat = new int[MAXF][MAXC];
		        int valor;
		        cargarMat(mat);
		        imprimirMat(mat);
		        
		        
		        
		        try{
		        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
		        System.out.println("Ingrese un valor entero positivo: ");
		        valor = Integer.valueOf(entrada.readLine());
		    
		        if ((valor>0) && (valor<=9)){
		            recorrerMat(mat, valor);
		            System.out.println("nueva mat: ");
			        imprimirMat(mat);
		        }else{
		            System.out.println("Numero ingresado incorrecto");
		        }
		}catch(Exception exc){
		        System.out.println(exc);
		}
		        
		}

		public static void recorrerMat(int[][] mat, int valor){
			System.out.println("entro 1");
		        for (int fila=0; fila<MAXF; fila++){
		            buscarSec(mat[fila], valor);
		        }
		}

		public static void buscarSec(int[] arr, int valor){
		    int inicio = 0, fin = 0;
		    int posMV = 0, suma = 0;
		    
		    while (inicio< MAXC){
		        inicio = inicioSec(arr, fin + 1);
		        if (inicio < MAXC){
		            fin = finSec(arr, inicio);
		            if (igualdad(arr,valor,inicio,fin)){
		                posMV = posMayorValor(arr, inicio, fin);
		                suma = sumaSec(arr, inicio, fin);
		                reemplazoSec(arr,posMV, suma);
		                
		            }
		        }
		   }
		}
		        
		        public static void reemplazoSec(int[] arr, int pos, int suma){
		        		arr[pos] = suma;
		               }
		            
		        
		        public static int sumaSec(int[] arr, int inicio, int fin){
		            int suma = 0;
		            for (int i = inicio; i<=fin; i++){
		                suma += arr[i];
		            }
		            return suma;
		        }
		        
		        public static boolean igualdad(int[] arr, int valor, int inicio, int fin){
		        	int pos = 0;
		            boolean iguales = false;
		            for (int i=inicio; i<=fin; i++){
		                if (arr[i] == valor){
		                    pos = i;   
		                    System.out.println("Posicion 1: " + i);
		                    for (int j=pos+1; j<=fin; j++)
		                    	if (arr[j] == valor){
		                    		iguales = true;
		                    		System.out.println("posicion 2: "+j);
		                    	}
		                    }
		                }		            
		            return iguales;
		        }

		        public static int posMayorValor(int[] arr, int inicio, int fin){
		            int mayorV = 0;    
		            for (int i=inicio; i<=fin; i++){
		                if (arr[i] > arr[i+1]){
		                    mayorV = i;
		                }
		            }
		            return mayorV;
		        }

		        public static int inicioSec(int[] arr, int pos){
		            while ((pos<MAXC) &&(arr[pos] == 0)){
		                pos++;
		            }
		            return pos;
		        }
		    
		        public static int finSec(int[] arr, int pos){
		            while ((pos<MAXC)&&(arr[pos] != 0)){
		                pos++;
		            }
		            return pos - 1;
		        }
		        
		        public static void cargarMat(int[][] mat){
		        	
		        	for (int fila = 0; fila < MAXF; fila++){
		        		cargar_arreglo_char(mat[fila]);
		    		}
		    		System.out.println(""); 		        	
		        }
		    		
		        public static void cargar_arreglo_char(int[] arr) {
		        	Random r = new Random();
		    		arr[0] = 0;
		    		arr[MAXC-1] = 0;
		    		for (int pos = 1; pos < MAXC-1; pos++){
		    			if (r.nextDouble()>probabilidad_numero){
		    				arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
		    			}
		    			else{
		    				arr[pos]=0;
		    			}
		    		}
		        }
		        
		        public static void imprimirMat(int[][] mat) {
		        	for (int i= 0; i< MAXF; i++){
						for (int j=0; j < MAXC; j++){
							System.out.print(mat[i][j] + "|");
						}
						System.out.println();
					}
		        }
}


