import java.util.Random;
public class ejercicio16 {
	public static final int MAX = 20;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
	public static void main(String[] args) {
		int[]arrentero;
		arrentero=new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arrentero);
		imprimir_arreglo_secuencias_int(arrentero);
		eliminar_secuencias_descendentes(arrentero);
	}
	public static void eliminar_secuencias_descendentes(int[]arr) {
		int inicio=0;
		int fin=-1;
		while(inicio<MAX) {
			inicio=inicio_secuencia(arr,fin+1);
			if(inicio<MAX)
				fin=fin_secuencia(arr,inicio);
				System.out.println(inicio+" y "+fin);
						if(eliminar(arr,inicio,fin)&&(inicio<fin)) {
							corrimientoIzq(arr,inicio,fin);
							fin=inicio;
						}
		}
		imprimir_arreglo_secuencias_int(arr);
	}
	public static boolean eliminar(int[]arr,int inicio,int fin) {
		int indice=inicio;
		while((indice<fin)&&(arr[indice]>arr[indice+1])) {
			indice++;
		}
			if(indice==fin) 
				return true;
			else
				return false;
			}
	public static void corrimientoIzq(int[] arr,int inicio, int fin){
		int indice = inicio;
		while(indice<=fin) {
			corrimientoIzq2(arr,inicio);
			indice++;
		}
		
	}
	public static void corrimientoIzq2(int[]arr,int inicio) {
		for(int i=inicio;i<(MAX-1);i++) {
			arr[i]=arr[i+1];
		}
	}
	public static int fin_secuencia(int[]arr,int inicio) {
		while ((inicio<MAX)&&(arr[inicio]!=0)) {
			inicio++;
		}
		return inicio-1;
	}
	public static int inicio_secuencia(int [] arr,int inicio) {
		while((inicio<MAX)&&(arr[inicio]==0)) {
			inicio++;
		}
		return inicio;
}
	public static void cargar_arreglo_aleatorio_secuencias_int(int []arr){
		Random r = new Random();
		arr[0] = 0;
		arr[MAX-1] = 0;
			for (int pos = 1; pos < MAX-1; pos++){
				if (r.nextDouble()>probabilidad_numero){
					arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1) + MINVALOR);
				}
				else{
					arr[pos]=0;
				}
			  }
			}
	public static void imprimir_arreglo_secuencias_int(int [] arr){
		System.out.print("Arreglo de secuencias int\n|");
			for (int pos = 0; pos < MAX; pos++){
				System.out.print(arr[pos]+"|");
			}
			System.out.print("\n");
		}

}
