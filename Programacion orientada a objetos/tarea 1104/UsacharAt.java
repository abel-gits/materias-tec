package clases;

public class UsacharAt {
	public static void main(String[]args){
		//este programa cuenta cuantas vocales hay en un nombre
		System.out.println("escribe un nombre");
		String n=" ";
		n=Leer.dato();
		int vocales=0;
		for(int i=0;i<=n.length()-1;i++){
			if(n.charAt(i)=='a'||n.charAt(i)=='e'||n.charAt(i)=='i'||n.charAt(i)=='o'||n.charAt(i)=='u'){
				vocales++;
			}
		}
		System.out.println("hay "+vocales+" vocales en "+n);
	}
	

}
