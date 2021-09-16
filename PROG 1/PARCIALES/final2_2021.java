import java.util.Random;

/*
 * Se tiene una matriz de caracteres separadas por espacion, que tiene un distinta cantidad de final y columnas.
 * Se pide:
 * Que elimine de cada fila la secuencia previa (si hay) y la secuenta posterios (si hay) a la secuencia central.
 * (central justo en el medio)
 */
public class final2_2021 {

	final static int MAXF = 5;
    final static int MAXC = 10;
    final static int MINVALOR = 1;
    final static int MAXVALOR = 9;
    final static Double probabilidad_numero = 0.1;

    public static void main(String[] args){
    	char[][] mat ={ {'0','1','2','3','0','0','1','2','3','0'},
    					{'0','2','3','0','0','1','2','0','1','0'},
    					{'0','1','1','0','0','0','0','0','0','0'},
    					{'0','1','1','0','0','0','1','1','0','0'},
    					{'0','1','1','0','0','0','1','1','0','0'}
    					};
	    imprimirMat(mat);
	    recorrerMat(mat);
	    System.out.println("Nueva mat: ");
	    imprimirMat(mat);
    }
    
    public static void recorrerMat(char[][] mat){
    	for (int fila=0; fila<MAXF; fila++){
    		buscarSecCentral(mat[fila]);
    	}
    }
    
    public static void buscarSecCentral(char[] arr){
    	int inicio = 0, fin = 0, cant = 0;
    	
    	while (inicio < MAXC){
    		inicio = inicioSec(arr, fin + 1);
    		if (inicio < MAXC){
    			fin = finSec(arr, inicio);
    			boolean existe = existeSecCentral(arr);
    			//cantidad de secuencias
    			//existe secuencia del medio,
    			//Si existe, busca la anterior y la siguiente, y correla.
    			if (existe){
    				//Buscar la secuencia anterior y la siguiente de la existente.
    				for (cant = fin - inicio + 1; cant > 0; cant --){
        				corrimiento_izq_fila(arr, inicio);	
    			}
    			
    			}
    			
    		}
    	}
    }
    
    public static boolean existeSecCentral(char[] arr){
    	boolean existe = false;
    	for (int i=0; i<=MAXC/2; i++){
    		if (arr[i]!=0){
    			existe = true;
    		}else{
    			existe =  false;
    		}
    	}
    	return existe;
    }
    
    public static void corrimiento_izq_fila(char[] arr, int inicio){
    	
    }
    
    public static int inicioSec(char[] arr, int pos){
    	while ((pos < MAXC)&&(arr[pos]=='0')){
    		pos++;
        	
    	}
    	return pos;
    }
    
    public static int finSec(char[] arr, int pos){
    	while ((pos < MAXC)&&(arr[pos]!='0')){
    		pos++;
    		
    	}
    	return (pos-1);
    	
    }
    
    public static void imprimirMat(char[][] mat) {
    	for (int i= 0; i< MAXF; i++){
			for (int j=0; j < MAXC; j++){
				System.out.print("|" +mat[i][j] + "|");
			}
				System.out.println("");
		}
    }
}
