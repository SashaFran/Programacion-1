package arreglos;
//Hacer un programa que dado el arreglo definido y precargado elimine del
//arreglo todas las ocurrencias de una secuencia patrón dada por otro arreglo
//de iguales características (solo tiene esa secuencia). Al eliminar se pierden los
//valores haciendo los corrimientos.

public class TP07_15{
	public static final int MAX=20;
	public static void main(String[] args){
		int [] arrenteros={0,1,2,3,0,0,0,7,8,9,0,5,3,0,0,0,1,2,3,0};
		int [] arrpatron={0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		imprimir_arreglo_secuencias_int(arrenteros);//metodo que se dio en clase 
		imprimir_arreglo_secuencias_int(arrpatron);
		buscar_e_elimnar_sec(arrenteros,arrpatron);//metodo que se desarrollo en clase y resuelve el ejercicio
		imprimir_arreglo_secuencias_int(arrenteros);
	}


// busca e elimina la secuencia que es igual a patron 
public static void buscar_e_elimnar_sec(int[] arrenteros,int[] arrpatron){
	int posInic,posFin;
	int posInicPatron,posFinPatron;
	posInic=0;
	posFin=-1;
	posFinPatron=-1;
	
	posInicPatron=obtener_inicio_secuencia(arrpatron,posFin+1);//busca inicio de patron
	posFinPatron=obtener_fin_secuencia(arrpatron,posInicPatron);//busca fin de patron
	
	while(posInic<MAX){//recorrido de secuencia
		posInic=obtener_inicio_secuencia(arrenteros,posFin+1);//busca pos inicial de la secuencia
		if(posInic<MAX)
			posFin=obtener_fin_secuencia(arrenteros,posInic);//busca pos fin de la secuencia
		if(sonIguales(arrenteros,arrpatron,posInic,posFin,posInicPatron,posFinPatron)){//revisa que ambas secuencias sean igual
			eliminar(arrenteros,posInic,posFin);//elimina secuencia
			posFin=posInic;
		}
	}
}
//metodo que elimina la secuencia. lo que hace este metodo es eliminar por la cantidad de casilleros que tiene la secuencia 
public static void eliminar(int[] arrenteros,int posInic,int posFin){
	int indice=posInic;
	while(indice<=posFin){
		corrimientoIzq(arrenteros,posInic);
		indice++;
	}
}
//corrimiento a izquierda hecho en clase
public static void corrimientoIzq(int[] arrenteros,int posInic){
	for(int i=posInic;i<(MAX-1);i++){
		arrenteros[i]=arrenteros[i+1];
	}
	
}
//revisa que ambos arreglos sean iguales en todos sus elementos y tamanio
public static boolean sonIguales(int[] arrenteros,int[]arrpatron,int posInic,int posFin,int posInicPatron,int posFinPatron){
	while((posInic<posFin)&&(posInicPatron<posFinPatron)&&(arrenteros[posInic]==arrpatron[posInicPatron])){//guarda con los rangos va hasta una posicion anterior porque en el siguiente if ya se paso
		posInic++;
		posInicPatron++;
	}
	if((posInic==posFin)&&(posInicPatron==posFinPatron)&&(arrenteros[posInic]==arrpatron[posInicPatron]))
		return true;
	else
		return false;
}


public static int obtener_inicio_secuencia(int[]arr,int pos){
	while((pos<MAX)&&(arr[pos]==0)){
		pos++;
	}
	return pos;
}

public static int obtener_fin_secuencia(int[]arr ,int pos){
	while((pos<MAX)&&(arr[pos]!=0)){
		pos++;
	}
	return pos-1;
}
public static void imprimir_arreglo_secuencias_int(int[] arr) {
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print(arr[pos] + "|");
		}
		System.out.print("\n");
	}
	


}