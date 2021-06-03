package parciales;

public class ejemplo_parcial_1 {

	/*
	Se tiene una matriz de enteros de tamanio 4*20 de secuencias de numeros entre 1 y 9 (por cada fila), separadas por 0.
    La matriz esta precargada, y ademas cada fila empieza y termina con uno o mas separadores 0. Se pide realizar un programa que:
    _por cada secuencia con tamanio par, agregue en un arreglo de enteros de tamanio 4*20 inicializado con ceros el promedio entero de la suma de los elementos de la secuencia.
    Cada agregado en el arreglo se debe realizar de forma consecutiva de izquierda a derecha y sin separadores.

Qué tenemos?
- Matriz de 4*20
- Secuencias de números entre 1 y 9
- Separadores son 0s
- La matriz está precargada
- Cada fila empieza y termina con uno o más 0s

Qué hay que hacer?
- Por cada secuencia
  - Si su tamaño es par
  	- Calcular promedio entero de la suma de sus elementos
    - Agregar promedio en el arreglo

*/
    public static final int MAX_FILA = 4;
	public static final int MAX_COLUMNA = 8;
	public static final int MAX = MAX_FILA * MAX_COLUMNA;
    
  	public static void main(String[] args) {
    	int[] prom_par_arr = new int[MAX];
		// int[][] mat = new int[MAX_FILA][MAX_COLUMNA];
      
      	inicializar_arr(prom_par_arr);
        // inicializar_mat(mat);
        int[][] mat = { {0, 21, 3, 4, 2, 0, 5, 0}, {0, 1, 3, 0, 1, 0, 5, 0}, {0, 1, 0, 4, 0, 0, 5, 0}, {0, 1, 3, 4, 1, 5, 5, 0}};
    
		imprimir_mat(mat);
      	imprimir_arr(prom_par_arr);
      
      	segundo_ejercicio(mat, prom_par_arr);
      
      	imprimir_mat(mat);
      	imprimir_arr(prom_par_arr);
    }
  
  	// Si quisieramos inicializar el arreglo de otra manera ya nos queda modularizado
  	public static void inicializar_arr(int[] arr) {
    	for (int i = 0; i < MAX; i++)
        	arr[i] = 0;
    }
  
  	public static void imprimir_mat(int[][] mat) {
    	for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(mat[i][j] + " ");
            }
    		System.out.println(" ");
        } 
    }
  
  	public static void imprimir_arr(int [] arr){
      	System.out.println("Elementos y posiciones del arreglo");
		for (int pos = 0; pos < MAX; pos++) {
       		System.out.println("Pos: " + pos + " Elemento: " + arr[pos]);
       	}
	}
  
    public static void segundo_ejercicio(int[][] mat, int[] arr) {
    	for (int fila = 0; fila < MAX_FILA; fila++) {
        	procesar_fila(mat[fila], arr);
        }
    }
  
  	public static int buscar_inicio_sec (int [] fila, int pos){  
        while((pos < MAX_COLUMNA) && (fila[pos] == 0)) {
        	pos++;
      	}
      	return pos;
    }
  
    public static int buscar_fin_sec(int [] fila, int pos){
    	while ((pos < MAX_COLUMNA) && (fila[pos] != 0)) {
        	pos++;
      	}
      	return pos - 1; // El último con el que sale del bucle es uno diferente de 0 (o no hay más valores)
    }
  
  	public static boolean cantidad_par(int inicio_pos, int final_pos) {
    	int cantidad = final_pos - inicio_pos + 1;
      	return cantidad % 2 == 0;
    }
  
  	public static int calcular_promedio_sec(int[] arr, int inicio, int fin) {
      int sum = 0;	
      for (int i = inicio; i <= fin; i++)
      	sum = sum + arr[i];
      return sum / (fin - inicio + 1);
    }
  
  	public static void agregar_promedio(int[] arr, int promedio) { // Se modulariza por el hecho de poder guardar de diferentes formas en el arreglo los valores (Por ejemplo podría ser de derecha a izquierda la carga de elementos)
    	int indice = 0;
    	while ((indice < MAX) && (arr[indice] != 0)) { // Busco el primer lugar vacio, debido a que se llena de izquierda a derecha
          indice = indice + 1;
        }
      	if (indice < MAX)
          arr[indice] = promedio;
    }
  
  	public static void procesar_fila(int[] fila, int[] result) {
    //	int suma = 0;
        int pos_sec_inicial = 0;
        int pos_sec_final = 0;
    //    int indice = 0;
      	int promedio = 0;
     	while(pos_sec_inicial < MAX_COLUMNA) {
          pos_sec_inicial = buscar_inicio_sec(fila, pos_sec_final + 1);
          if(pos_sec_inicial < MAX_COLUMNA) {
            pos_sec_final = buscar_fin_sec(fila, pos_sec_inicial);
            if(cantidad_par(pos_sec_inicial, pos_sec_final)) { // Acá podríamos evaluar lo que necesitemos de la secuencia para tomar o no una acción
                promedio = calcular_promedio_sec(fila, pos_sec_inicial, pos_sec_final); // Acá podríamos hacer lo que necesitemos con la secuencia porque ya la detectamos y tenemos acceso a sus valores
              	agregar_promedio(result, promedio);
            }    
          } 
      	}
    }
}
