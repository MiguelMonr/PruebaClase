
public class ManejadorMatrices {
	public static<T extends Comparable<T>> int buscaPorRenglon(T a[][], int f, T valor) {
		int n,m,j;
		boolean encontre;
		
		n=a.length;
		m=a[0].length;
		j=0;
		encontre= false;
		while(j<m && encontre== false) {
			if(a[f][j]!= null && a[f][j].equals(valor))
				encontre= true;
			else
				j++;
		}
		if(!encontre)
			j=-1;
		return j;
		
		}
	
	public static <T extends Comparable <T>> String creaString(T a[][]) {
		StringBuilder sb;
		int i,j,n,m;
		n=a.length;
		m=a[0].length;
		sb= new StringBuilder();
		
		for(i=0; i<n; i++) {
			for(j=0; j<m; j++)
				sb.append(a[i][j]+"\t");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static <T extends Comparable<T>> int buscaPorColumna(T a[][], int c, T valor) {
		int m, i, pos;
		m=a[0].length;
		i=0;
		
		while(i<m && !a[i][c].equals(valor))
			i++;
		if(i<m)
			pos=i;
		else
			pos=-1;
		return pos;

		
	}

	public static <T extends Comparable<T>> int[] busca(T a[][], T valor) {	
		int n, m,i=0,j=0;
		int[] resp= {-1,-1};
		
		boolean encontre=false;
		n=a.length;
		m=a[0].length;
		
		while(i<n && !encontre) {
			while(j<m && !encontre) {
				if(a[i][j]!=null && a[i][j].compareTo(valor)==0) {
					encontre=true;
					resp[0]=i;
					resp[1]=j;
				}
				else 
					j++;
			}
			if(!encontre) 
				i++;
		}
		return resp;
	
	}
	
		
		public static <T extends Comparable <T>> int indicaMayorColumna(T a[][], int c) {
		int i,mayor = 0;
		
		for(i=1; i<c; i++){
			if(a[i][c].compareTo(a[i][mayor])>0)
				mayor=c;
		}
		return mayor;	
	}
		
		public static<T extends Comparable<T>> int indicaMenorColumna(T a[][],int c) {
			int i,menor=0;
			
			for(i=1; i<c; i++){
				if(a[i][c].compareTo(a[i][menor])<0)
					menor=c;	
			}
			return menor;
		}
		
		public static<T extends Comparable<T>> int indicaMayorFila(T a[][],int f) {
			int j,mayor=0;
			for(j=1;j<f; j++) {
				if(a[f][j].compareTo(a[mayor][j])>0)
					mayor=f;
			}
			return mayor;
		}
		public static<T extends Comparable<T>> int indicaMenorrFila(T a[][],int f) {
			int j,menor=0;
			for(j=1;j<f; j++) {
				if(a[f][j].compareTo(a[menor][j])<0)
					menor=f;
			}
			return menor;
		}
		
		public static <T extends Comparable <T>> boolean sonIguales(T a[][], T b[][]) {
			boolean iguales;
			int i,j,n1,n2,m1,m2;
			
			n1= a.length;
			m1= a[0].length;
			n2= b.length;
			m2= b[0].length;
			iguales= true;
			if(n1==n2 && m1==m2) {
				i=0;
				while(i<n1 && iguales) {
					j=0;
					while(j<m1 && iguales) {
						if(!a[i][j].equals(b[i][j]))
							iguales= false;
						j++;
					}
					i++;
				}
			}
			else
				iguales= false;
			return iguales;
				
		}
	
		
		public static <T extends Comparable<T>> boolean matrizDiagonalInfMay(T a[][]) {
			boolean igual=true;
			int n, m,i=0, j;
			n=a.length;
			m=a[0].length;
			if(n==m) {
			 while(i<n && igual){ 
					j=i; 
				while(j+i<m && igual) {
				if((a[i+j][i]==null && a[i][i+j]!=null ) || (a[i+j][i]!=null && a[i][i+j]==null ) || a[i+j][i].compareTo(a[i][i+j])!=0) 
						igual=false;
						else
							j++;
					 }
					 if(igual) 
						 i++;
				}
			}
			else
				igual=false;
			
			return igual;
		}
		
		

		
		
}
