// Ordenamiento entre posicciones especificas ingresadas por usuario.

package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class practica {

	final static int MAX = 10;
	public static void main(String[] args){
			System.out.println("Arreglo original: ");
		int[] arr = {0,9,5,3,8,0,0,7,8,0};
		for (int i= 0; i<MAX; i++){
			System.out.print("["+ arr[i]+"]");	
		}
		
		int val1, val2;
		try{
			BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
			System.out.println("Ingresar valor 1: ");
			val1 = Integer.valueOf(entrada.readLine());
			System.out.println("Ingresar valor 2: ");
			val2 = Integer.valueOf(entrada.readLine());
			
			if ((val1 > 0) && (val2 > 0) && (val1 != val2)){
				if (val2>val1){
					ordenarArr(arr, val1, val2);
				}else{
					System.out.println("valores erroneos");
				}
			}else{
				System.out.println("valores erroneos");
			}
		}catch (Exception exc){
			System.out.println( exc );
		}

	}
	public static void ordenarArr (int[] arr, int val1, int val2){
		System.out.println("Arreglo nuevo: ");
        for (int i = val1-1; i < MAX; i++) {   
            for (int j = i+1; j <= val2; j++) {   
               if(arr[i] > arr[j]) {  
                  int temp = arr[i];  
                   arr[i] = arr[j];  
                   arr[j] = temp;  
               }   
            } 
            System.out.print("[" +arr[i]+ "]");  
        }  
        
        
	}
}
