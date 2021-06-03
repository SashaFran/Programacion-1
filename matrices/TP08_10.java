package matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

//Hacer un programa que dada la matriz de secuencias de enteros definida
//y precargada, permita obtener a través de métodos la posición de inicio y
//la posición de fin de la secuencia ubicada a partir de una posición entera
//y una fila, ambas ingresadas por el usuario. Finalmente, si existen imprima
//por pantalla ambas posiciones obtenidas.

public class TP08_10 {

		public static final int MAXFILA = 4;
	    public static final int MAXCOLUMNA = 20;
	    public static final int MAXVALOR = 9;
	    public static final int MINVALOR = 1;
	    public static final double probabilidad = 0.4;

	    public static void main(String[] args) {
	    	
	        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	        int [][] matint = new int[MAXFILA][MAXCOLUMNA];
	        int fila = 0, posicion = 0;
	        cargarMatriz(matint);
	        imprimirMatrizEnteros(matint);

	        try {
	            System.out.println("Ingresar una fila:");
	            fila = Integer.valueOf(entrada.readLine());
	            
	            System.out.println("Ingresar una posición (número entero):");
	            posicion = Integer.valueOf(entrada.readLine());
	        } catch (Exception exc) {
	            System.out.println(exc);
	        }
	        
            if ((fila<MAXFILA)&&(posicion<MAXCOLUMNA)&&(fila>=0)&&(posicion>=0)){
            	//System.out.println("fila: "+fila+ " posicion: "+posicion);
            	
	            int posicionInicio = buscarPosicionInicio(matint, fila, posicion);
	            System.out.println("La secuencia inicia en la posición: " + posicionInicio);
	            
	            int posicionFin = buscarPosicionFin(matint, fila, posicionInicio);
	            System.out.println("Y termina en la posición: " + posicionFin);
            }else{
            	System.out.println("Ingreso valores incorrectos.");
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

	    public static int buscarPosicionInicio(int[][] matint, int fila, int posicion) {
	        int posicionInicio = posicion;
	        if (matint[fila][posicion] == 0) {
	            posicionInicio++;
	        } else {
	            while (matint[fila][posicion] != 0) {
	                posicion--;
	            }
	            posicionInicio = posicion + 1;
	        }
	        return posicionInicio;
	    }

	    public static int buscarPosicionFin(int[][] matint, int fila, int posicionInicio) {
	        while (matint[fila][posicionInicio] != 0) {
	            posicionInicio++;
	        }
	        int posicionFin = posicionInicio - 1;
	        return posicionFin;
	    }
	}

