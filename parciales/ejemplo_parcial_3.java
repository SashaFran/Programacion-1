package parciales;

/*
Se tiene una matriz de caracteres de tamanio 4*20 de secuencias de caracteres entre 'a' y 'z' (por cada fila), separadas por espacios ' '.
La matriz esta precargada, y ademas cada fila empieza y termina con uno o mas separadores espacios. Se pide realizar un programa que:
_por cada secuencia, agregue en un arreglo de enteros de tamanio 4*20 inicializado con ceros la cantidad de vocales que tiene cada secuencia.
Cada agregado en el arreglo se debe realizar de forma consecutiva de izquierda a derecha y sin separadores.
*/

public class ejemplo_parcial_3 {

	public static final int MAXFILA = 4;
	public static final int MAXCOLUMNA = 20;
	public static final int MAX = MAXFILA*MAXCOLUMNA;

	public static void main(String[] args) {
		int [] arrint;
		char [][] matchar;
		arrint = new int[MAX];
		matchar = new char[MAXFILA][MAXCOLUMNA];
		//cargar_arreglo_int(arrint);
		//cargar_matriz_aleatorio_secuencias_char(matchar);
		
		realizar_segundo_ejercicio(matchar, arrint);
		
	}
	
	public static void realizar_segundo_ejercicio(char [][] matchar, int [] arrint){
		int index = 0;
		int i=0;
		int inicio=-1;
		int fin=-1;
		int f=0;
		while(f<MAXFILA) {
			while(i<MAXCOLUMNA) { 
				while(i<MAXCOLUMNA-1 && matchar[f][i]==' ') { 
					i++;
				}
				if(matchar[f][i]!=' ') { 
					inicio=i;
					while(i<MAXCOLUMNA-1 && matchar[f][i]!=' ') { 
						fin=i;
						i++;
					}
				} 
				if(inicio!=-1 && fin!=-1) { 
					arrint[index] = cantVocales(matchar, inicio, fin, f);
					index++;
				}
				i++;
				fin=-1;
				inicio=-1; 
			}
			f++;
			i=0;
		}
	}
	
	private static int cantVocales(char [][] matchar, int inicio, int fin, int f) {
		int suma = 0;
		for(int i = inicio; i<=fin; i++) {
			if(matchar[f][i]=='a' || matchar[f][i]=='e' || matchar[f][i]=='i' || matchar[f][i]=='o' || matchar[f][i]=='u') {
				suma++;
			}
		}
		return suma;
	}
	
}
