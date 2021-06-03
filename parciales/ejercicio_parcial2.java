package parciales;
import java.util.Random;


public class ejercicio_parcial2 {
	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final double probabilidad_letra = 0.4;
	
	public static void main(String[] args) {
		char [][] matriz = new char [MAXFILA][MAXCOLUMNA];
		cargar_matriz_aleatorio_char(matriz);
		System.out.println("Matriz original: ");
		imprimir_matriz(matriz);
		borrar_secuencias(matriz);
		System.out.println("Matriz nueva: ");
		imprimir_matriz(matriz);
	}
	
	public static int obtener_fin_secuencia (char [] arr, int indice) {
		int pos = indice;
		while (pos < MAXCOLUMNA && arr[pos] != ' ') {
			pos++;
		}
		if (pos < MAXCOLUMNA)
			return pos - 1;
		else
			return -1;
	}
	
	public static int obtener_inicio_secuencia (char [] arr, int indice) {
		int pos = indice;
		while (pos < MAXCOLUMNA && arr[pos] == ' ') {
			pos++;
		}
		if (pos < MAXCOLUMNA)
			return pos;
		else
			return -1;
	}
	public static void borrar_secuencias(char [][] matriz) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			borrar_tamanio_secuencia(matriz[fila]);
		}
	}
	
	public static void eliminar(char [] arr,int posInic,int posFin){
		int indice = posInic;
		while (indice <= posFin){
			corrimientoIzq(arr,posInic);
			indice++;
		}
	}
	
	public static void corrimientoIzq(char [] arr,int posInic){
		for(int i = posInic; i < (MAXCOLUMNA-1); i++){
			arr[i]=arr[i+1];
		}
		
	}
	
	public static void borrar_tamanio_secuencia(char [] arr) {
		int inicio,fin,cantidad;
		int inicioTercera= -1;
		int finTercera = -1;
		int finCuarta = -1;
		cantidad = 0;
		inicio = obtener_inicio_secuencia(arr,0);
		while (inicio != -1) {
			fin=obtener_fin_secuencia(arr,inicio);
			if (fin != -1) {
				cantidad++;
				if (cantidad == 3) {
					inicioTercera = inicio;
					finTercera = fin;
				}
				if (cantidad == 4) {
					finCuarta = fin;
				}
				inicio = obtener_inicio_secuencia(arr,fin + 1);
			}
		}
		if (cantidad > 3) {
			eliminar(arr,inicioTercera,finCuarta);
		} else if (cantidad == 3) {
			eliminar(arr,inicioTercera,finTercera);
		} else {
			System.out.println("Hay menos de 3 secuencias en la fila");
		}
	}
	
	//-------------------------------------------------------------------------
	
	public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr) {
		Random r = new Random();
		arr[0] = ' ';
		arr[MAXCOLUMNA-1] = ' ';
		for (int pos = 1; pos < MAXCOLUMNA-1; pos++){
			if(r.nextDouble()>probabilidad_letra){
				arr[pos]=(char)(r.nextInt(26) + 'a');
			}
			else{
				arr[pos]=' ';
			}
		}
	}
	
	public static void cargar_matriz_aleatorio_char(char [][] matriz) {
		for (int fila = 0; fila < MAXFILA; fila++){
			cargar_arreglo_aleatorio_secuencias_char(matriz[fila]);
		}
	}
	
	public static void imprimir_matriz(char [][] matriz) {
		for (int fila = 0; fila < MAXFILA; fila++) {
			for (int columna = 0; columna < MAXCOLUMNA; columna++) {
				System.out.print("|"+matriz[fila][columna]);
			}
			System.out.println("|");
		}
	}

}
