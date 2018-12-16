import java.util.*;
public class GaussJordan{
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Esta programa resuelve sistemas de ecuaciones por el metodo de gauss-jordan ");
		int	orden=0;
		do{
			System.out.println("Escribe el orden del sistema de ecuaciones(2-5):");
			orden=leer.nextInt();
		}while(!(orden>1&&orden<6));
		double matriz[][] = new double[orden][orden+1];
		double matriz2[][] = new double[orden][orden+1];
		int f=0,c=0;
		System.out.println("Escribe los datos de la matriz");
		for ( f=0;f<orden ;f++ ) {
			System.out.println("Escribe la ecuacion "+(f+1));
			for ( c=0;c<orden+1 ;c++ ) {
				System.out.println("Escribe el coeficiente de la incognita "+(c+1));
				matriz[f][c]=leer.nextDouble();
				double z=0;
				z=matriz[f][c];
				matriz2[f][c]=z;
			}
			
		}

		String concepto[]=new String[orden];
		System.out.println("Escribe los conceptos del problema");
		for (int a=0;a<orden ;a++ ) {
			System.out.println("Escribe el concepto "+(a+1));
			concepto[a]=leer.next();
		} 

		for (int k1=0;k1<orden-1 ;k1++ ) {
			double piv=matriz[k1][k1];
			for (int f1=k1+1;f1<orden ;f1++ ) {
				double mult =matriz[f1][k1];
				for (int c1=k1;c1<orden+1 ;c1++ ) {
					matriz[f1][c1]=((piv*matriz[f1][c1])-(mult*matriz[k1][c1]));
				}
			}
		}

		for (int k2=orden-1;k2>-1;k2-- ) {
			 double piv=matriz[k2][k2];
			
			for (int f2=0;f2<k2;f2++ ) {
				double factor=matriz[f2][k2]/piv;

				for (int c2=k2;c2<orden+1 ;c2++ ) {
					matriz[f2][c2]=(matriz[f2][c2]-(factor*matriz[k2][c2]));
				}
			}
		}
		
		for (int f3=0;f3<orden ;f3++ ) {
			matriz[f3][orden]=matriz[f3][orden]/matriz[f3][f3];
			matriz[f3][f3]=matriz[f3][f3]/matriz[f3][f3];
		}


		System.out.println("Instituto tecnologico de culiacan"+"\n"+"Ingenieria en sistemas computacionales"+"\n"+"Abel Robles Montoya"+"\n"+"metodo Gauss-Jordan"+"\n"+"horario:11-12");
		System.out.println("Matriz de datos");
		mostrar(orden,matriz2);
		System.out.println("Matriz transformada");
		mostrar(orden,matriz);
		System.out.println("Resultados");
		for (int p=0;p<orden ;p++ ) {
			int y=round(matriz[p][orden]);
			System.out.println(concepto[p]+"= "+y);
		}
		System.out.println("___________________________");

	
	}
	public static void mostrar(int orden,double matriz[][]){
		for (int p=0;p<orden ;p++ ) {
			for (int c=0;c<orden+1 ;c++ ) {
				int x=round(matriz[p][c]);
			System.out.print(x+"\t\t");
			}
			System.out.print("\n"+"\n");
		}
	}
	
	public static int round(double d){
    double dAbs = Math.abs(d);
    int i = (int) dAbs;
    double result = dAbs - (double) i;
    if(result<0.5){
        return d<0 ? -i : i;            
    }else{
        return d<0 ? -(i+1) : i+1;          
    }
}
}