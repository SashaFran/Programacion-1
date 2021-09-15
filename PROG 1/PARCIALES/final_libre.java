package finales;

/*
 * Dada una matriz de caracteres de MxN compuesta de secuencias de caracteres separadas por espacios,
 * hacer un programa completo para borrar la secuencia central de cada fila (secuencia corresponndiente a 
 * la mitad de la cantidad de sencuencias que tiene a fila, sin importar si la cantidad es par o impar). 
 * Para borrar reaizar los desplazamientos necesarios y n utiizar estructuras auxiliares.
 * Suponer que a matriz se encuentra cargada y que cada fila comienza y termina con caracteres espacio.
 */
public class final_libre {

	final static int MAXF = 5;
	final static int MAXC = 10;
	
	public static void main(String[] args){
		//char[][] mat = new char[MAXF][MAXC];
		char[][] mat = {{' ','1','2',' ','1','2',' ','1','2',' '},
						{' ',' ','1','2',' ','1','2',' ','1',' '},
						{' ','1',' ','1','2',' ','1','2',' ',' '},
						{' ','1','2',' ',' ','1','2',' ',' ',' '},
						{' ','1','2',' ','1','2',' ','1','2',' '}};
		//cargarMat(mat);
		System.out.println("Matriz original: ");
		imprimirMat(mat);
		recorrerMat(mat);
		System.out.println("Nueva Matriz: ");
		imprimirMat(mat);
	}
	
	public static void recorrerMat(char[][] mat){
		for (int fila=0; fila < MAXF; fila++){
			buscarSec(mat[fila]);
		}
	}
	
	public static void buscarSec(char[] arr){
		int inicio = 0, fin = 0, cant = 0;
		
		while (inicio< MAXC){
			inicio = inicioSec(arr, fin + 1);
			if (inicio < MAXC){
				fin = finSec(arr, inicio);
				cant = cantidadSec(arr);
				int largo = (fin-inicio+1);
				if(cant > 2){
					for(int i=MAXC/2+1; i>largo; i--){
						sortLeft(arr, i);
					}
						
					
					
				}
			}
		}
	}
	public static void sortLeft(char[] arr, int inicio){
		for (int i = inicio; i < MAXC-1; i++){
			arr[i] = arr[i+1];
		}
	}
	
	public static int cantidadSec(char[] arr){
		int cant = 0;
		
		for (int col = 0; col < MAXC-1; col++){
			if ((arr[col] == ' ')&&(arr[col + 1] != ' ')){
				cant++;
			}
		}
		return cant;
	}
	
	public static int inicioSec(char[] arr, int pos){
		while ((pos < MAXC)&&(arr[pos]== ' ')){
			pos++;
		}
		return pos;
	}
	
	public static int finSec(char[] arr, int pos){
		while ((pos < MAXC)&&(arr[pos]!= ' ')){
			pos++;
		}
		return (pos - 1);
	}
	
	public static void imprimirMat(char[][] mat){
		for (int fila = 0; fila < MAXF; fila++){
			System.out.print("|");
			for (int columna = 0; columna < MAXC; columna++){
				System.out.print(mat[fila][columna]+"|");
			}
			System.out.println("");
		}
	}
	
	//public static void cargarMat(char[][] mat){}
}
