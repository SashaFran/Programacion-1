import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dado el arreglo definido y precargado permita
//obtener a través de métodos la posición de inicio y la posición de fin de la
//secuencia ubicada a partir de una posición entera ingresada por el
//usuario. Finalmente, si existen imprima por pantalla ambas posiciones
//obtenidas.

public class TP07_10 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arreglo;
		arreglo = new int [MAX];
		int numero, inicio, fin;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try{
			cargar_secuencia_aleatoria_int(arreglo);
			imprimir_secuencias_int(arreglo);
			System.out.println("Ingrese una posición:");
			numero = Integer.valueOf(entrada.readLine());
			
			// Busco inicio de la secuencia y la guardo en una variable
			inicio = buscar_inicio(arreglo, numero);
			// Busco el final de las secuencia a partir del inicio de la misma
			fin = buscar_fin(arreglo, inicio);
			
			System.out.println("Inicio: " + inicio + "\nFinal: " + fin);
		}catch (Exception exc) {
			System.out.println(exc);
		}
	}
	
    public static int buscar_fin(int[]arr, int fin){
    	while ((fin < MAX)&&(arr[fin]!=0)){
    		fin++;	
    	}
    	return fin-1;
    }
	
	public static int buscar_inicio(int[]arr, int inicio){
		while ((inicio < MAX)&&(arr[inicio]==0)){
			inicio++;
		}
		return inicio;
		}
	
	public static void imprimir_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]+"|");
		}
		System.out.print("\n");
	}
	
	public static void cargar_secuencia_aleatoria_int(int [] arr){
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


	}
		
