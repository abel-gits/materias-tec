//este programa lee el mes y el dia e imprime la estacion del 
//año al que corresponde
import java.util.Scanner;
public class Nueve {
public static void main(String[]args) {
Scanner leer = new Scanner(System.in);
int mes, dia;
System.out.println("escribe el dia");
dia=leer.nextInt();
System.out.println("escribe el mes");
mes=leer.nextInt();
switch (mes) {
case 1:System.out.println("es invierno");break;
case 2:System.out.println("es invierno");break;
case 3:if (dia>=21)
System.out.println("es primavera");break;
case 4:System.out.println("es primavera");break;
case 5:System.out.println("es primavera");break;
case 6:if (dia>=21)
System.out.println("es verano");break;
case 7:System.out.println("es verano");break;
case 8:System.out.println("es verano");break;
case 9:if (dia>=21)
System.out.println("es otoño");break;
case 10:System.out.println("es otoño");break;
case 11:System.out.println("es otoño");break;
case 12:System.out.println("es invierno");break;
default:System.out.println("error");break;
}
}
}