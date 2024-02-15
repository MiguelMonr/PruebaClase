import java.util.ArrayList



public class ManejadorArreglos {
	public static<T extends Comparable<T>> int indiceMayor(T a[],int n){
		int mayor, i;
		mayor=0;
		for(i=1; i<n; i++)
			if(a[i].compareTo(a[mayor])>0)
				mayor= i;
			return mayor;		
	}
	public static <T extends Comparable <T>>  int indiceMenor(T a[],int n){
		int menor, i;
		menor=0;
		for(i=1; i<n; i++)
			if(a[i].compareTo(a[menor])<0)
				menor= i;
			return menor;		
	}
	
	public static <T extends Comparable <T>> int cuantosMayorA(T a[], int n, T p) { //la p tambien es T para que aplique con genericos, en los normales se define el tipo
		int i, cuantos;
		
		cuantos=0;
		for(i=0; i<n; i++)
			if(a[i].compareTo(p)>0)
				cuantos++;
		return cuantos;	
		}

	public static int cuantosMenorA(double a[], int n, double p) {
		int i, cuantos;
		
		cuantos=0;
		for(i=0; i<n; i++)
			if(a[i]<p)
				cuantos++;
		return cuantos;
	}
	
	public static <T extends Comparable<T>> int cuantosMenorA(T a[], int n, T p) {
		int i, cuantos;
		
		cuantos=0;
		for(i=0; i<n; i++)
			if(a[i].compareTo(p)<0)
				cuantos++;
		return cuantos;
	}
	
	public static <T extends Comparable<T>> ArrayList<T> cualesMayorA(T a[], int n, T p){
		int i;
		ArrayList<T> cuales;
		
		
		cuales= new ArrayList<T>();
		for(i=0; i<n; i++)
			if(a[i].compareTo(p)>0)
				cuales.add(a[i]);
		return cuales;
		
	}
	
	
	public static <T extends Comparable<T>> void recorreDerechaApartirPos(T a[],int n, int pos){
		int i;
		for(i=0;i>pos; i--){
			a[i]=a[i-1];
			a[pos]=null;
		}
	}
	
	public static <T extends Comparable <T>> void recorreIzquierdaApartirPos(T a[], int n, int pos) {
		int i;
		for(i=pos;i<n;i++)
			a[i]=a[i+1];
		a[n-1]=null;
	}

	public static <T extends Comparable<T>> int buscSeq(T a[], int n, T valor) {
		int i, pos;
			
		i=0;
		while(i<n && !a[i].equals(valor)) {
			i++;}
		
		if(i<n)
			pos= i;
		else
			pos=-1;
		return pos;
	}

	public static <T  extends Comparable<T>> int buscBinaria(T a[], int n, T valor) { // SE USA CUANDO YA ESTA ORDENADO
		int  inicio, fin, mitad, num;
		inicio=0;
		fin= n-1;
		mitad=(inicio+fin)/2;
		
		while(inicio<= fin && a[mitad]!= valor) {
			if(valor.compareTo(a[mitad])>0)
				inicio= mitad+1;	
			else
				fin= mitad-1;
				
			mitad=(inicio+fin)/2;
		}
		if(inicio<= fin)
			num= mitad;
		else
			num= -inicio-1;
		return num;
}

	public static  <T  extends Comparable<T>> boolean altaOrdenada (T uno, T a[], int ocupados, int MAX) {
		boolean resp;
		
		int pos;

		if(ocupados<MAX) {// si hay lugar
			
			pos= buscBinaria(a, ocupados, uno);
			if(pos>0)
				resp= false; // ya esta
			else {
				pos= (pos*-1)-1;
				recorreDerechaApartirPos(a, ocupados, pos);
				a[pos]= uno;
				resp= true;
				
			 }
			
		}
		else
			resp=false;
		return resp;
		}

	public static  <T  extends Comparable<T>> boolean altaFinal(T uno, T a[], int ocupados, int MAX) {
		boolean resp;
		int pos;
		
		if(ocupados<MAX) {
		pos= buscSeq(a, ocupados, uno);	
		
			if(pos<ocupados) { //ya esta 
				resp= false;}
				else
					{a[ocupados]=uno;
					resp= true;}	
		}
		else
			resp= false; // no hay lugar
		return resp;
	}
	
	public static<T extends Comparable<T>>T bajaOrdenada(T uno, T a[], int ocupados){ // el T se pone en los genericos junto con extends y comparable (ayuda a agregar el compareTo), se debe poner implements cuando manejas uno diferente a T
		int pos;
		T resp;
		
		pos=buscBinaria(a, ocupados, uno);
		if(pos>=0){ //si esta
			uno=a[pos];
			recorreIzquierdaApartirPos(a,ocupados,pos);
			resp=uno;
		}
		else
			resp=null;
		return resp;
	}
	
	public static<T extends Comparable<T>>T baja(T uno, T a[], int ocupados){
		int pos;
		T resp;
		
		pos=buscSeq(a, ocupados, uno);
		if(pos>=0){ //si esta
			uno=a[pos];
			recorreIzquierdaApartirPos(a,ocupados,pos);
			resp=uno;
		}
		else
			resp=null;
		return resp;
	}
	
	
	
}
