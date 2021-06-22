//Intercambio de secuencias iguales
package arreglos;
public class practica_2 {

	final static int MAX = 10;
	
	public static void main(String[] args){
		int[] arrA = {0,1,2,3,0,0,4,8,9,0};
		int[] arrB = {0,0,0,1,2,3,0,0,0,0};
	
		int ini_A = ini_A(arrA);
		int ini_B = ini_A(arrB);
		if ((ini_A < MAX - 1) && (ini_B < MAX -1)){
			int fin_A = fin_A(arrA, ini_A);
			int fin_B = fin_B(arrB, ini_B);
			
			System.out.println("valor de inicio A: " + arrA[ini_A]);
			System.out.println("valor de inicio B: " + arrB[ini_B]);
			if (arrA[ini_A] == arrB[ini_B]){
				//intercambiar_secuencias(arrA,ini_A,arrB,ini_B);
				int mayor = mayornumeropar(arrA, ini_A, fin_A);
				System.out.println("Mayor: " + mayor);
			}
		}
	}
	
	public static int mayornumeropar(int[] arrA, int ini_A, int fin_A) {
		int mayorV = 0;
		for (int i=ini_A; i<=fin_A; i++){
			if(arrA[ini_A]>arrA[ini_A+1]){
				arrA[ini_A] = mayorV;
			}
		}
		if ((mayorV%2)==0){
			return mayorV;
		}else{
			return -1; //COn esto va a dar error en la condicion de busqueda_central y no va a avanzar.
		}	
	}

	public static int fin_B(int[]arr, int ini){
		int fin = ini;
		while ((fin<MAX)&&(arr[fin]!=0)){
			fin++;
		}	
		System.out.println("Posicion fin secuencia B: "  + fin);
		return fin - 1; 
	}
	public static int fin_A(int[]arr, int ini){
		int fin = ini;
		while ((fin<MAX)&&(arr[fin]!=0)){
			fin++;
		}
		System.out.println("Posicion fin secuencia A: "  + fin);
		return fin - 1; 
	}
	public static int ini_A(int[] arr){
		int ini = 0;
		while ((ini < MAX)&&(arr[ini]== 0)){
			ini++;
		}
		System.out.println("Posicion inicio secuencia A: "  + ini);
		return ini;
	}
	public static int verificar_igualdad(int[] arrA, int ini_A, int[] arrB, int fin_A, int fin_B, int ini_B){
		System.out.println("entro 1");
		if ((ini_A == ini_B)&&(fin_A== fin_B)){
			System.out.println("entro 2");
			return 1;
		}else{
			return -1;	
		}
	}
	
	public static void intercambiar_secuencias(int[] arrA, int ini_A, int[] arrB, int ini_B){
		int aux = 0;
		aux = arrA[ini_A];
		arrA[ini_A] = arrB[ini_B];
		arrB[ini_B] = aux;
	}
}
