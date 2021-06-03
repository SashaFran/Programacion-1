import java.util.Random;

public class ordenamiento {

	public static int MAX = 10;
	public static int MINV = 0;
	public static int MAXV = 9;
	public static void main(String[] args){
		int [] arr;
		arr = new int[MAX];
		
		carga_arr(arr);
		imprimir_arr(arr);
		division_arr(arr);
		imprimir_arr(arr);
	}
	public static void division_arr(int[] arr) {
		for (int i=0; i<MAX-1; i++){
			for (int j=i; j<MAX; j++){
				if(arr[i]>arr[j]){
					int aux = arr[i];
					arr[i] = arr[j];
					arr[j] = aux;
				}
			}
		}
		
	}
	public static void imprimir_arr(int[] arr) {
		for (int i = 0; i<MAX; i++){
			System.out.println("Arr["+i+"]=>: " + arr[i]);
		}
		
	}
	public static void carga_arr(int[] arr) {
		Random r = new Random();
		for (int i=0; i< MAX; i++){
			arr[i] = (r.nextInt(MAXV - MINV+1) + MINV);
		}
		
	}
}
