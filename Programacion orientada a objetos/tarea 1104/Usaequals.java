package clases;
import java.util.*;
public class Usaequals {
public static void main (String []args){
	//este programa lee las respuestas correctas de un examen y las compara con las respondidas
	System.out.println("escribe cuantas preguntas son");
	int a=0;
	int f=1;
	a=Leer.datoInt();
	Vector c = new Vector();
	Vector in = new Vector();
	System.out.println("escribe las respuestas correctas ");
	for (int i=0;i<=a-1;i++){
		System.out.println("escribe la respuesta "+f++);
		String b=" ";
		b=Leer.dato();
		c.addElement(b);
	}
	for (int i=0;i<=a-1;i++){
		System.out.println("escribe las respuestas a comparar ");
		String b=" ";
		b=Leer.dato();
		in.addElement(b);
	}
	if (c.equals(in)){
		System.out.println("todas las respuestas son correctas");
	}
	else {
	int aciertos=0;
	for(int d=0;d<=a-1;d++){
		if(c.elementAt(d).equals(in.elementAt(d))){
			aciertos++;
		}
	}
	System.out.println("hay "+aciertos+" aciertos");
	}
}
}
