import java.util.*;
class Montante{
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Esta programa resuelve sistemas de ecuaciones por el metodo de la montante ");
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
		//Proceso de la montante
		double pivAn=1;
		double pivAct=1;
		
		for (int k=0;k<orden ;k++ ) {
			pivAct=matriz[k][k];
			for ( f=0;f<orden ; f++) {
				for ( c=0;c<orden+1 ; c++) {
					if (c!=k&&f!=k) {
						
						matriz[f][c]=((pivAct*matriz[f][c])-(matriz[f][k]*matriz[k][c]))/pivAn;
					}
				}
			}
	
			//poner ceros abajo del pivote
			for (f=0;f<orden ;f++ ) {
				if (f!=k) {
					matriz[f][k]=0;
					
				}
			}
			pivAn=pivAct;

		}

		for ( f=0;f<orden ;f++ ) {
			matriz[f][orden]=matriz[f][orden]/matriz[f][f];
			matriz[f][f]=matriz[f][f]/matriz[f][f];
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
				int x=round(matriz[p][c];
			System.out.print(x+"\t\t");
			}
			System.out.print("\n"+"\n");
		}
	}
	
	public static int round(double d){
    double dAbs = Math.abs(d);
    int i = (int) dAbs;
    double result = dAbs - (double) i;
    if(result<0.1){
        return d<0 ? -i : i;            
    }else{
        return d<0 ? -(i+1) : i+1;          
    }
}
}