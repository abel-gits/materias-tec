package POO;

public class UsaGranjas {
	public static void main(String[] args) {
		Fumigaciones g=new Fumigaciones();
		Fumigaciones[] f = new Fumigaciones[5];
		String nom=null;
		String poblacion=null;
		int num=0;
		int tipo=0;
		for(int i=0;i<=2;i++){
			System.out.println("escribe el nombre");
			
			nom=Leer.dato();
			
			System.out.println("escribe la poblacion");
			
			poblacion=Leer.dato();
			
			System.out.println("escribe el tipo");
			
			tipo=Leer.datoInt();
			
			
			System.out.println("escribe el numero de hectareas a fumigar");
			
			num=Leer.datoInt();
			
		
			f[i]=new Fumigaciones(nom,poblacion,tipo,num,0);
			
			
	}
		CalculaCosto(f);
		ImprimirGranjeros(f);
		int tipo1=0;
		int tipo2=0;
		int tipo3=0;
		int tipo4=0;
		for(int i=0;i<=2;i++){
			switch(f[i].getTipo()){
			case 1:tipo1++;break;
			case 2:tipo2++;break;
			case 3:tipo3++;break;
			case 4:tipo4++;break;
			}
			
		}
		int costototal=0;
		for(int i=0;i<=2;i++){
			costototal=f[i].getCosto()+costototal;
		}
		System.out.println("tipo 1: "+tipo1+"  tipo 2: "+tipo2+" tipo 3: "+tipo3+" tipo4: "+tipo4);
		System.out.println("el costo total por todos los granjeros es "+costototal);
		
	}
	public static void CalculaCosto(Fumigaciones[]f){
		for(int i=0;i<=2;i++){
			switch (f[i].getTipo()) {
					case 1:
						int a=0;
						a=f[i].getNum()*50;
			f[i].setCosto(a);System.out.print("fs cvbfghg");break;
					case 2:
						int b=0;
						b=f[i].getNum()*70;
						f[i].setCosto(b);break;
					case 3:
						int c=0;
						c=f[i].getNum()*80;
						f[i].setCosto(c);break;
					case 4:
						int d=0;
						d=f[i].getNum()*120;
						f[i].setCosto(d);break;
						
			}
		}
	}
	public static void ImprimirGranjeros(Fumigaciones[]f ){
		for(int i=0;i<=2;i++){
			System.out.println(f[i].getNombreGranjero()+"    el costo total de fumigacion es  "+f[i].getCosto());
			
		}
		
	}

}
