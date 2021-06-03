package parciales;

/*
Se tiene una matriz de enteros de tamanio 4*20 de secuencias de numeros entre 1 y 9 (por cada fila), separadas por 0.
La matriz esta precargada, y ademas cada fila empieza y termina con uno o mas separadores 0. Se pide realizar un programa que:
_para todas las filas inserte al final de cada secuencia el valor correspondiente a la suma de su contenido (lo que suma cada secuencia).
Suponer que cada fila de la matriz tiene espacio para agregar esos valores.
*/
/* Utilizar la siguiente estructura de programa para resolver en enunciado, definiendo e implementando todos los metodos necesarios (salvo la carga inicial de las estructuras)*/


public class ejemplo_parcial_6 {

	public static final int maxColumna=20; 
    public static final int maxFila=4; 
    
    public static void main(String[] args) {
        int[][] matriz = new int[maxFila][maxColumna];  
        //asumo que la matriz esta precargada
        realizarSegundoEjercicio(matriz);
    } 
    public static int buscaInicioSecuencia(int[] arreglo,int pos){ 
        while((pos<maxColumna)&&(arreglo[pos]==0)){ 
            pos++;
        } 
        return pos;
    } 
    public static int buscaFinSecuencia(int[] arreglo, int pos){ 
        while ((pos<maxColumna)&&(arreglo[pos]!=0)){ 
            pos++;
        } 
        return pos;
    } 
    public static int calculaSuma(int[] arreglo, int posInicial, int posFinal){ 
        int suma=0;
        for (int i = posInicial; i < posFinal; i++) {
            suma+=arreglo[i];
        } 
        return suma;
    } 
    public static void agregarSuma(int[] arreglo, int suma,int posFinal){
        for (int i = maxColumna-1; i > posFinal; i--) {
            arreglo[i]=arreglo[i-1];
        }
        arreglo[posFinal]=suma; 
    } 
    public static void insertarSuma(int[] arreglo ){
        int posInicial=0,posFinal=0,suma=0; 
        while(posInicial<maxColumna){ 
            posInicial=buscaInicioSecuencia(arreglo,posFinal); 
            posFinal=buscaFinSecuencia(arreglo,posInicial); 
            suma=calculaSuma(arreglo,posInicial,posFinal); 
            agregarSuma(arreglo,suma,posFinal); 
        }
    }   
    public static void realizarSegundoEjercicio(int[][] matriz){ 
        for (int i = 0; i < maxFila; i++) {
            insertarSuma(matriz[i]);
        }
    }
	
}
