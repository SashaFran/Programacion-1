package matrices;

import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de caracteres definida y
//precargada, permita encontrar por cada fila la posición de inicio y fin de la
//anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima
//posición de la fila).

public class TP08_12 {

	public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {
        int [][] matint = new int[MAXFILA][MAXCOLUMNA];

        cargarMatriz(matint);
        imprimirMatrizEnteros(matint);
        AnteultimaSec(matint);
    }

    public static void AnteultimaSec(int[][] matint) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            int posFin = PosFin(matint, fila);
            int posIni = posIni(matint, fila, posFin);
            int ultPos = posIni - 1;
            while (matint[fila][ultPos] == 0) {
                ultPos--;
            }
            int priPos = posIni(matint, fila, ultPos);
            System.out.println("La anteúltima secuencia de la fila " + fila + " empieza en la posición " + priPos + " y termina en la posición " + ultPos);
        }
    }
    
    public static int posIni(int[][] matint, int fila, int posFin) {
        while (matint[fila][posFin] != 0) {
            posFin--;
        }
        int posicionInicio = posFin + 1;
        return posicionInicio;
    }

    public static int PosFin(int[][] matint, int fila) {
        int pos = MAXCOLUMNA - 1;
        while (matint[fila][pos] == 0) {
            pos--;
        }
        return pos;
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
            if (r.nextDouble() > probabilityNumber) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
            }
        }
        array [MAXCOLUMNA - 2] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR); // Evito que el anteúltimo número sea un 0 y me de error al buscar la última secuencia
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