package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class TP07_19 {

		public static char MINVALOR = 1;
		public static char MAXVALOR = 10;
		public static int MAX = 10;
		public static double probabilidad_numero = 0.4;
		
		
		public static void main (String [] args) {	
		int[] ORIGINAL = new int[MAX];
		int[] ORDEN1 = new int[MAX];
		int pos=0;
			
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			try{
				cargar_arreglo_aleatorio_secuencias_int(ORIGINAL);
				imprimir_arreglo_int(ORIGINAL);
				System.out.println("ORDEN1");
				inicializar_arreglo_indice(ORDEN1);
				obtener_suma_par(ORIGINAL,ORDEN1);
				imprimir_arreglo_int(ORDEN1);
			
				System.out.println("Ingrese una posición dentro del arreglo.");
				pos= Integer.valueOf(entrada.readLine());
				if(pos<MAX) {
					eliminar_secuencia_arreglo_pos(ORIGINAL,pos);
					imprimir_arreglo_int(ORIGINAL);
					actualizar_arreglo_ind(ORDEN1,pos);
					imprimir_arreglo_int(ORDEN1);
				}
				
			}
			catch (Exception exc){
				System.out.println(exc);
			}			
		}
		
		public static void inicializar_arreglo_indice(int [] arr){
			for (int pos = 0; pos < MAX; pos++){
				arr[pos] = -1;
			}
		}
		
		public static void ordenar_arreglo_char_asc(char [] original) {
			char aux='0';
			int pos_menor;
			
			for (int i = 0; i < MAX; i++) {
				pos_menor = i;

				for (int j = i + 1; j < MAX; j++){
						if (original[j] < original[pos_menor]) {
							pos_menor = j;
						}
				}
				if (pos_menor != i){
					aux = original[i];
					original[i] = original[pos_menor];
					original[pos_menor] = aux;
				}
			}
		}

		//-----------------------------------------------------------------


		public static int buscar_inicio_secuencia (int[]arr, int fin) {
			int inicio = fin;
			while ((inicio<MAX)&&(arr[inicio]==0)) {
				inicio++;
			}
			return inicio;
		}

		public static int buscar_fin_secuencia (int [] arr, int inicio){
			int fin =inicio;
			while ((fin<MAX)&&(arr[fin]!=0)) {
				fin++;
			}
			return fin-1;
		}
		
		public static void obtener_suma_par(int[] original, int[]orden){
			int inicio,fin,suma, inicio_par, fin_par;
			inicio = 0;
			fin = 0;
			suma= 0;
			inicio_par=0;
			fin_par=0;
			
			while (inicio < MAX){
				inicio = buscar_inicio_secuencia(original,fin); 
				if (inicio < MAX){
					fin = buscar_fin_secuencia(original,inicio); 
					suma = obtener_suma_secuencia(original,inicio,fin);
					if (suma%2==0) {
						inicio_par = inicio; 
						fin_par = fin; 
						insertar_ordenado_arreglo_pos(orden,inicio_par,fin_par, suma);
					}
				}
				inicio=fin+1;
				fin=fin+1;
			}
		}

		public static void insertar_ordenado_arreglo_pos(int[] arrindices,int inicio_par, int fin_par, int suma){
			int posicion=buscar_pos_arreglo_ord(arrindices, inicio_par);
			arrindices[posicion]=inicio_par;
		}
		
		public static int buscar_pos_arreglo_ord(int[] arrindices, int inicio_par){
			int posicion=0;
			while ((posicion<MAX) && (arrindices[posicion]!=-1)){
				posicion++;
			}
			return posicion;
		}
		public static void corrimiento_der(int[] arr,int pos, int max) {
			while (pos<max){
				arr[max] = arr[max-1];
				max--;
			}
		}   
		
		public static int obtener_suma_secuencia(int[] arr, int inicio, int fin){
			int suma = 0;
				while (inicio <= fin){
				suma+=arr[inicio];
				inicio++;
			}
			return suma;
		}
		
		
		public static void cargar_arreglo_aleatorio_secuencias_int(int []
				arr){
			Random r = new Random();
			arr[0] = 0;
			arr[MAX-1] = 0;
			for (int pos = 1; pos < MAX-1; pos++){
				if (r.nextDouble()>probabilidad_numero){
					arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
				}
				else{
					arr[pos]=0;
				}
			}
		}
		
		public static void imprimir_arreglo_int(int [] arr){
			for (int pos = 0; pos < MAX; pos++){
				System.out.print("|"+arr[pos]);
			}   
			System.out.println("|");
		}  
		
		public static void corrimiento_izq_int(int[] arr,int pos) {
			while (pos<MAX-1){
				arr[pos] = arr[pos+1];
				pos++;
			}
		}  
		
		//------------------------------------------------------------------------------

	public static void eliminar_secuencia_arreglo_pos(int[] original,int pos){	
			int inicio,fin;
			inicio = 0;
			fin = pos;
			
			
				if(original[pos]!=0) {
					inicio = pos;
				}else {
				inicio = buscar_inicio_secuencia(original,fin);
				}
				if (inicio < MAX){
					fin = buscar_fin_secuencia(original,inicio); 
					corrimiento_izq_int(original,pos);
				}
			
	}
		public static void actualizar_arreglo_ind(int[] arrindices,int pos){
			int posicion = 0;
			while ((posicion < MAX) && (arrindices[posicion] != -1)){
				if (arrindices[posicion] >= pos){
					arrindices[posicion]--;
					if (arrindices[posicion] >= MAX){
						corrimiento_izq_int(arrindices,posicion);
					}
				}
				posicion++;
			}
		}
	}

		
		//-----------------------------------------------------------
