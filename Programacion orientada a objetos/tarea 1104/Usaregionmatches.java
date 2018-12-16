package clases;
public class Usaregionmatches {
	public static void main(String[]args){
		//este programa compara dos string del mismo tmaño
		System.out.println("escribe dos string de la misma longitud");
		String a=" ",b=" ";
		int c=0;
		do{
			a=Leer.dato();
			b=Leer.dato();
		}while(a.length()!=b.length());
		for(int i=0;i<=a.length()-1;i++){
			
			if(a.regionMatches(true, i,b,i,a.length()-i)==true){
				System.out.println("son iguales en la posicion "+i);
				c++;
			}
			
		}
		if(c<1)System.out.println("no son iguales en ninguna posicion");
		
	}
	}
