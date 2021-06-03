package arreglos;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TP07_18 {
	
	public static final int MAX = 10;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	
	public static void main(String[] args) {
       char [] arreg= new char [MAX];
       int [] orden1= new int[MAX];
       
       inicializar_arreglo(orden1);
       cargar_arreglo_ordenado_char(arreg);
       imprimir_arreglo_char(arreg);
       index_vocales(arreg,orden1);
       imprimir_arreglo_index(orden1, arreg);
	}
	
	public static void index_vocales(char [] arreg,int [] orden1){
		int j=0;
		for (int i=0; i< MAX; i++){
			if(( arreg[i]== 'a')||(arreg[i]== 'e')||(arreg[i]== 'i')||(arreg[i]== 'o')||(arreg[i]== 'u')){
				orden1[j]= arreg[i];
				j++;
			}
		}
		
	}
	
	public static void inicializar_arreglo(int [] orden1){
		for( int i=0; i<MAX;i++){
			orden1[i]= -1;
		}
	}
	
	public static void cargar_arreglo_ordenado_char(char [] arr){
		//Random r = new Random();
		BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
       
		for (int pos = 0; pos < MAX; pos++){
			
			try{
			System.out.println("ingrese char :");
		    arr[pos]=entrada.readLine().charAt(0);
		    
			}catch(Exception exc){
	       	 System.out.println(exc);
		    }
		}  
	}
	
	public static void imprimir_arreglo_index(int [] index,char [] arr){
		int i=0;
		while (i< MAX){
			if (index[i]!= -1){
				System.out.print(arr[index[i]]+" ");
			}
			if (index[i]== -1){
				i= MAX;
			}
			i++;
		}
	}
	
	public static void imprimir_arreglo_char(char [] arr){
		for (int pos = 0; pos < MAX; pos++){
			System.out.print(arr[pos]);
		}
	}
	
}
