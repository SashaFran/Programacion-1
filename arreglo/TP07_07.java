import java.io.BufferedReader;
import java.io.InputStreamReader;
//Hacer un programa que dado un arreglo ordenado creciente de enteros
//de tamaño 10 que se encuentra precargado, solicite al usuario un numero
//entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
//que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
//y colocar el numero en el arreglo en la posición indicada.

public class TP07_07 {
	public static int MAX = 10;
	public static int MINV = 0;
	public static int MAXV = 9;
	
		public static void main(String[] args){
			int [] arr = {0,10,20,30,40,50,60,70,80,90};
			int valor;
			
			BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
			try{
				
				imprimir_arr(arr, MAX);
				System.out.println("Ingrese un valor: ");
				valor = Integer.valueOf(entrada.readLine());
				if(valor > 0){
						int pos = posicion_valor(valor, arr);
						agregar_valor(valor, arr, pos, MAX);	
						}	
				imprimir_arr(arr, MAX);
			}catch (Exception exc){
				System.out.println( exc );
			}
		}
		
		public static void agregar_valor(int valor, int[] arr, int pos, int MAX) {
			int indice = MAX-1;
			while (indice > pos){
				arr[indice] = arr[indice-1];
				indice--;
				if(indice < MAX){
					arr[indice] = valor;
				}
			}
		}
		
		public static int posicion_valor(int valor, int[] arr) {
			int pos=0;
			for (int i= 0; i<MAX; i++){
				if(arr[i]< valor)
					pos++;
			}
			return pos;
		}
		
		public static void imprimir_arr(int[] arr, int MAX) {
			System.out.println("Arreglo: ");
			for (int i = 0; i < MAX; i++){
				System.out.print( arr[i] + "|");
			}	
		}
	}
		

