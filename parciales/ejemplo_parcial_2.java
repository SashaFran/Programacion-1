package parciales;

import java.util.Random;

/*Se tiene una matriz de enteros de tamanio 4*20 de secuencias de numeros entre 1 y 9 (por cada fila), separadas por 0.
La matriz esta precargada, y ademas cada fila empieza y termina con uno o mas separadores 0. Se pide realizar un programa que:
_para todas las filas elimine la antepenultima secuencia (si tiene).
*/


public class ejemplo_parcial_2 {

	public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static int MAX = 20;
    public static final int MAXVALOR = 10;
    public static final int MINVALOR = 1;
    public static final double probabilidad_numero = 0.4;

    public static void main(String[] args) {
        int[][] matint;
        matint = new int[MAXFILA][MAXCOLUMNA];
        int veces_busco_sec = 3;
        cargar_matriz_aleatorio_secuencias_int(matint);
        imprimir_matriz_secuencias_int(matint);
        //RESOLVER EL ENUNCIADO DENTRO DEL METODO QUE SIGUE: realizar_segundo_ejercicio(...)
        realizar_segundo_ejercicio(matint, veces_busco_sec);
        imprimir_matriz_secuencias_int(matint);

    }

    public static void cargar_matriz_aleatorio_secuencias_int(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_aleatorio_secuencias_int(mat[fila]);
        }
        System.out.println("");
    }

    public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;
        for (int pos = 1; pos < MAX - 1; pos++) {
            if (r.nextDouble() > probabilidad_numero) {
                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                arr[pos] = 0;
            }
        }
    }

    public static void imprimir_matriz_secuencias_int(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            System.out.print("|");
            for (int columna = 0; columna < MAXCOLUMNA; columna++) {
                System.out.print(mat[fila][columna] + "|");
            }
            System.out.println("");
        }
    }

    public static void realizar_segundo_ejercicio(int[][] matint, int veces_busco_sec) {
        //EN ESTE METODO DEBE RESOLVER EL ENUNCIADO MODULARIZANDO SEGUN CORRESPONDA
        for (int fila = 0; fila < MAXFILA; fila++) {
            encontrar_antepenultima_secuencia_fila(matint[fila], veces_busco_sec);
        }
    }

    public static void encontrar_antepenultima_secuencia_fila(int[] arr, int veces_busco_sec) {
        int fin = MAXCOLUMNA;
        int inicio = MAXCOLUMNA - 1;
        int i = 0;
        while ((0 <= inicio) && (i < veces_busco_sec)) {
            inicio = buscar_posicion_inicio(arr, fin - 1);
            if (inicio >= 0) {
                fin = buscar_posicion_fin(arr, inicio);
                i++;
                System.out.println(i);
            }
        }
        if (i == veces_busco_sec) {
            eliminar_antepenultima_secuencia(arr, inicio, fin);
        } else {
            System.out.println("La antepenultima secuencia no existe.");
        }
    }

    public static void eliminar_antepenultima_secuencia(int[] arr, int inicio, int fin) {
        int cant_corrimientos = (inicio + 1) - fin;
        System.out.println(cant_corrimientos);
        while (cant_corrimientos > 0) {           
            corrimiento_izq(arr, fin);
            cant_corrimientos--;
        }
    }

    public static int buscar_posicion_inicio(int[] arr, int pos) {
        while ((pos >= 0) && (arr[pos] == 0)) {
            pos--;
        }
        return pos;
    }

    public static int buscar_posicion_fin(int[] arr, int pos) {
        while ((pos >= 0) && (arr[pos] != 0)) {
            pos--;
        }
        return pos + 1;
    }

    public static void corrimiento_izq(int[] arr, int fin) {
        for (int i = fin; i < MAXCOLUMNA - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }
	
}
