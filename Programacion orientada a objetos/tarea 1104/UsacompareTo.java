package clases;
public class UsacompareTo {
	public static void main(String []args){
		//este programa lee dos cadenas de string y las ordena de mayor a menor longitud
		System.out.println("escribe dos cadenas");
		String a=" ",b=" ";
		a=Leer.dato();
		b=Leer.dato();
		if(a.compareTo(b)>=0){
			System.out.println(a+"\n"+b);
		}
		else
			if(a.compareTo(b)<0){
				System.out.println(b+"\n"+a);
			}
			else System.out.println(a+"\n"+b);
	}

}
