package matrices;

import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de enteros definida y
//precargada permita encontrar por cada fila la posición de inicio y fin de la
//secuencia cuya suma de valores sea mayor.

public class TP08_11 {

	public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidad = 0.4;

    public static void main(String[] args) {
    	
        int [][] matint = new int[MAXFILA][MAXCOLUMNA];
        cargarMatriz(matint);
        imprimirMatrizEnteros(matint);
        
       sumasecuencias(matint);
    }

	public static int posFin(int[][] matint, int fila, int posIni) {
		while (matint[fila][posIni] != 0){
			posIni++;
		}
		int posFin = posIni - 1;
		return posFin;
	}
	
	public static int posIni(int[][] matint, int fila, int pos) {
		while (matint[fila][pos] == 0){
			pos++;
		}
		return pos;
	}
	
    public static void sumasecuencias(int[][] matint) {
		for (int fila=0; fila<MAXFILA; fila++){
			int pos = 0;
			int sumaMayor = 0;
			int inicio = 0;
			int fin = 0;
			int posIni = posIni(matint, fila, pos);
			while (inicio < MAXCOLUMNA-1){
				int posFin = posFin(matint, fila, posIni);
				int suma = 0;
				for (int i = posIni; i<= posFin && i< MAXCOLUMNA-1; i++){
					suma += matint[fila][i];
				}
				if (suma > sumaMayor){
					sumaMayor = suma;
					inicio = posIni;
					fin = posFin;
				}
				System.out.println("La suma de la secuencia de posiciones "+posIni+" hasta "+posFin+ " en la fila "+fila+" es: "+suma);
				pos = posFin + 1;
				if (pos < MAXCOLUMNA - 1){
					posIni = posIni(matint, fila, pos);
				}else{
					break;
				}
			}
			 System.out.println("La suma de los valores de la secuencia entre posiciones " + inicio + " y " + fin + " es la más grande.");
		}
	}

	public static void cargarMatriz(int [][] matint) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargarArreglo(matint[fila]);
        }
        System.out.println("");
    }

    public static void cargarArreglo(int [] array) {
        Random r = new Random();
        array[0] = 0;
        array[MAXCOLUMNA - 1] = 0;
        for (int i = 1; i < MAXCOLUMNA - 1; i++) {
            if (r.nextDouble() > probabilidad) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
            }
        }
    }

    public static void imprimirMatrizEnteros(int [][] matint) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            for (int columna = 0; columna < MAXCOLUMNA; columna++) {
                System.out.print("[" + matint[fila][columna] + "]");
            }
            System.out.println("");
        }
    }


}

