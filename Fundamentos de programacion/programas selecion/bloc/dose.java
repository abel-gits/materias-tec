//este programa informa a un policia si un conductor puede 
//conducir segun los resultados de la prueba de alcohol
import java.util.Scanner;
public class Dose {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
float a;
System.out.println("escriba el nivel de alcohol");
a=leer.nextFloat();
if ((a>=0)&(a<=0.07)) 
System.out.println("se considera aceptable");
else
if (a>=0.08)
System.out.println("se considera inaceptable");
else
if (a<0)
System.out.println("error");
}
}
